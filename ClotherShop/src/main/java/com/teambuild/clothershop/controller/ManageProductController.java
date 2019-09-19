package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.*;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import com.teambuild.clothershop.validate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Controller
public class ManageProductController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    // đối tượng được lưu thông tin chính
    private static Product insertProduct = new Product();
    // lưu chi tiết sản phẩm vào
    private static Set<ProductDetails> set = new HashSet();

    @GetMapping("admin-getAllProduct")
    public String getAllProduct(ModelMap modelMap) {
        List<Product> productList = manageProductServiceImpl.productList();
        modelMap.addAttribute("getAllProduct", productList);
        return "listProduct";
    }

    @GetMapping("admin-addProduct")
    public String addProduct(ModelMap modelMap) {
        List<Color> colorList = manageProductServiceImpl.getAllColor();
        List<Size> sizeList = manageProductServiceImpl.getAllSize();
        List<Kind> kindList = manageProductServiceImpl.getAllKind();
        List<Producer> producerList = manageProductServiceImpl.getAllProducer();
        modelMap.addAttribute("colorList", colorList);
        modelMap.addAttribute("sizeList", sizeList);
        modelMap.addAttribute("kindList", kindList);
        modelMap.addAttribute("producerList", producerList);
        return "addProduct";
    }

    // check main product
    @PostMapping("checkInfoProduct")
    @ResponseBody
    public String checkInfoProduct(@RequestParam String code, @RequestParam String name, @RequestParam String price,
                                   @RequestParam String describe, @RequestParam String producer) {
        boolean check = false;
        if (CodesValidate.codesValidate(code)) {
            List<Product> productList = manageProductServiceImpl.productList();
            for (int i = 0; i < productList.size(); i++) {
                if (productList.get(i).getCodesProduct().equals(code.trim().toUpperCase())) {
                    return "Code already exists";
                } else {
                    if (productList.get(i).getNameProduct().equals(name.trim())) {
                        return "Name already exists";
                    } else {
                        check = true;
                    }
                }
            }// end for
            if (check) {
                if (PriceValidate.priceValidate(price)) {
                    if (CodesValidate.codesValidate(name)) {
                        return "Wrong format Name of product";
                    } else {
                        if (EmptyValidate.emptyValidate(describe)) {
                            if (EmptyValidate.emptyValidate(producer)) {
                                // đã vượt qua all điều kiện
                                // lưu all thông tin chính của sản phẩm vào đối tượng insertProduct
                                // thông tin chính của sản phẩm
                                this.insertProduct.setCodesProduct(code.trim().toUpperCase());
                                this.insertProduct.setNameProduct(name.trim());
                                this.insertProduct.setPrice(Double.parseDouble(price.trim()));
                                this.insertProduct.setDescribeProduct(describe);
                                Producer insertProducer = new Producer();
                                insertProducer.setIdProducer(Integer.parseInt(producer));
                                this.insertProduct.setProducer(insertProducer);
                                // end
                                return "true";
                            } else {
                                return "You need select Producer";
                            }
                        } else {
                            return "Wrong format Describe of product";
                        }
                    }
                } else {
                    return "Wrong format Price of product";
                }
            }
        } else {
            return "Wrong format Code of product";
        }
        return "false";
    }

    // lưu sản phẩm vào khung chứa
    @PostMapping("save-product")
    @ResponseBody
    public String saveProduct(@RequestParam String color, @RequestParam String kind, @RequestParam String size,
                              @RequestParam String quality, @RequestParam String file) {
        if (EmptyValidate.emptyValidate(color)) {
            if (EmptyValidate.emptyValidate(kind)) {
                if (EmptyValidate.emptyValidate(size)) {
                    if (QualityValidate.qualityValidate(quality)) {
                        if (EmptyValidate.emptyValidate(file)) {
                            // lấy tên file
                            String fileName = file.substring(12);

                            // lưu chi tiết sản phẩm vào set static
                            Color insertColor = new Color();
                            insertColor.setIdColor(Integer.parseInt(color.trim()));

                            Kind insertKind = new Kind();
                            insertKind.setIdKind(Integer.parseInt(kind.trim()));

                            Size insertSize = new Size();
                            insertSize.setIdSize(Integer.parseInt(size.trim()));

                            Image insertImage = new Image();
                            insertImage.setPath(fileName.trim());

                            ProductDetails productDetails = new ProductDetails();
                            productDetails.setQuality(Integer.parseInt(quality.trim()));
                            productDetails.setColor(insertColor);
                            productDetails.setKind(insertKind);
                            productDetails.setSize(insertSize);
                            productDetails.setImage(insertImage);
                            this.set.add(productDetails);
                            // đã lưu vào set static

                            this.insertProduct.setProductDetails(this.set);
                            return "true";
                        } else {
                            return "You need select image";
                        }
                    } else {
                        return "You need enter quality";
                    }
                } else {
                    return "You need select size";
                }
            } else {
                return "You need select kind";
            }
        } else {
            return "You need select color";
        }
    }

    // save set sản phẩm xuống data
    @PostMapping("insertProduct")
    @ResponseBody
    public String insertProduct() {
        try {
            manageProductServiceImpl.insertProduct(this.insertProduct);
            // set lại null cho khung chứa
            this.set.clear();
            this.insertProduct = new Product();
            return "true";
        }catch (Exception e) {
            return "false " + e;
        }
    }

    // phần save file của sản phẩm
    @Autowired
    ServletContext context;

    // lưu file vào hệ thống
    @PostMapping("saveAndMoveFile")
    @ResponseBody
    public String moveFile(MultipartHttpServletRequest multipartHttpServletRequest) {
        String path_save_file = context.getRealPath("/resources/images/");
        Iterator<String> stringIterator = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(stringIterator.next());
        File file = new File(path_save_file + multipartFile.getOriginalFilename());
        try {
            multipartFile.transferTo(file);
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    // LƯU item mới
    @PostMapping("saveItem")
    @ResponseBody
    public String saveItem(@RequestParam String header, @RequestParam String item) {
        List<Color> colorList = manageProductServiceImpl.getAllColor();
        List<Size> sizeList = manageProductServiceImpl.getAllSize();
        List<Kind> kindList = manageProductServiceImpl.getAllKind();
        List<Producer> producerList = manageProductServiceImpl.getAllProducer();
        String subString = header.trim().toUpperCase().substring(7);
        if (subString.trim().equals("KIND")) {
            for (Kind k:kindList) {
                if (k.getNameKind().toUpperCase().equals(item.trim().toUpperCase())) {
                    return "Kind already exist";
                } else {
                    Kind kind = new Kind();
                    kind.setNameKind(item.trim().toUpperCase());
                    manageProductServiceImpl.addKind(kind);
                    return "true";
                }
            }
        } else if (subString.trim().equals("COLOR")) {
            for (Color c:colorList) {
                if (c.getNameColor().trim().toUpperCase().equals(item.trim().toUpperCase())) {
                    return "Color already exist";
                } else {
                    Color color = new Color();
                    color.setNameColor(item.trim().toUpperCase());
                    manageProductServiceImpl.addColor(color);
                    return "true";
                }
            }
        } else if (subString.trim().equals("SIZE")) {
            int sizeParseInt = Integer.parseInt(item.trim());
            for (Size s:sizeList) {
                if (s.getNumber() == sizeParseInt) {
                    return "Size already exist";
                } else {
                    Size size = new Size();
                    size.setNumber(sizeParseInt);
                    manageProductServiceImpl.addSize(size);
                    return "true";
                }
            }
        } else {
            String splitName = item.substring(0, item.indexOf("/"));
            String splitAddress = item.substring(item.indexOf("/") + 1);
            if (SpecialCharactersValidate.specialCharactersValidate(splitName) && SpecialCharactersValidate.specialCharactersValidate(splitAddress)) {
                for (Producer producer:producerList) {
                    if (!producer.getNameProducer().toUpperCase().equals(splitName.toUpperCase())) {
                        Producer producer1 = new Producer();
                        producer1.setNameProducer(splitName);
                        producer1.setAddress(splitAddress);
                        manageProductServiceImpl.addProducer(producer1);
                        return "true";
                    } else {
                        return "Name Producer already exist";
                    }
                }
            } else {
                return "You don't write special characters";
            }
        }
        return "false";
    }

    // lấy tất cả thông tin sản phẩm theo id
    @GetMapping("admin-details-product")
    public String getProductById(@RequestParam String id) {
        manageProductServiceImpl.selectProductById(Integer.parseInt(id));
        return "";
    }
}
