package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.*;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import com.teambuild.clothershop.validate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ManageProductController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    // đối tượng được lưu thông tin chính
    private Product insertProduct = new Product();
    // lưu chi tiết sản phẩm vào
    private Set<ProductDetails> set = new LinkedHashSet<>();

    @GetMapping("admin-getAllProduct")
    public String getAllProduct(ModelMap modelMap) {
        List<Product> productList = manageProductServiceImpl.getAllProduct();
        modelMap.addAttribute("getAllProduct", productList);
        return "listProduct";
    }

    @GetMapping("admin-addProduct")
    public String addProduct(ModelMap modelMap) {
        return "addProduct";
    }

    // check main product
    @PostMapping("checkInfoProduct")
    @ResponseBody
    public String checkInfoProduct(@RequestParam String code, @RequestParam String name, @RequestParam String price,
                                   @RequestParam String describe, @RequestParam String producer) {
        reset();
        boolean check = false;
        if (CodesValidate.codesValidate(code)) {
            List<Product> productList = manageProductServiceImpl.getAllProduct();
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
                                this.insertProduct.setCreated_time(java.time.LocalTime.now().toString());
                                this.insertProduct.setCreated_date(java.time.LocalDate.now().toString());
                                this.insertProduct.setUpdated_time("0");
                                this.insertProduct.setUpdated_date("0");
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
        String check = findProductDetails(color, size, kind, quality, file);
        if (check.equals("true")) {
            // lấy tên file
            String fileName = file.substring(12);
            // lưu chi tiết sản phẩm vào set
            ProductDetails productDetails = objectProductDetails(color, size, kind, quality, fileName);
            this.set.add(productDetails);
            // đã lưu vào set
            this.insertProduct.setProductDetails(this.set);
            return "true-" + set.size();
        } else {
            return check;
        }
    }

    // update vào khung chứa
    @PostMapping("update-product-at-add")
    @ResponseBody
    public String updateProductAtAdd(@RequestParam String id, @RequestParam String color, @RequestParam String kind, @RequestParam String size,
                                     @RequestParam String quality, @RequestParam String file) {
        String check = findProductDetails(color, size, kind, quality, file);
        if (check.equals("true")) {
            int idReal = Integer.parseInt(id) - 1;
            ProductDetails productDetailsNew = objectProductDetails(color, size, kind, quality, file);
            List<ProductDetails> productDetailsList = new ArrayList<>();
            productDetailsList.addAll(set);
            productDetailsList.set(idReal, productDetailsNew);
            set.clear();
            set.addAll(productDetailsList);
            this.set.add(productDetailsNew);
            return check;
        } else {
            return check;
        }
    }

    @PostMapping("delete-In-Container")
    @ResponseBody
    public String deleteInContainer(@RequestParam String id) {
        int sizeSet = set.size();
        int idReal = Integer.parseInt(id) - 1;
        List<ProductDetails> productDetailsList = new ArrayList<>();
        productDetailsList.addAll(set);
        productDetailsList.remove(idReal);
        set.clear();
        set.addAll(productDetailsList);
        int sizeSetNew = set.size();
        if (sizeSet > sizeSetNew) {
            return "true-" + sizeSetNew;
        } else {
            return "false";
        }
    }

    private ProductDetails objectProductDetails(String color, String size, String kind, String quality, String image) {
        Color insertColor = new Color();
        insertColor.setIdColor(Integer.parseInt(color.trim()));

        Kind insertKind = new Kind();
        insertKind.setIdKind(Integer.parseInt(kind.trim()));

        Size insertSize = new Size();
        insertSize.setIdSize(Integer.parseInt(size.trim()));

        Image insertImage = new Image();
        insertImage.setPath(image.trim());

        ProductDetails productDetails = new ProductDetails();
        productDetails.setQuality(Integer.parseInt(quality.trim()));

        productDetails.setColor(insertColor);
        productDetails.setKind(insertKind);
        productDetails.setSize(insertSize);
        productDetails.setImage(insertImage);

        return productDetails;
    }

    private String findProductDetails(String color, String size, String kind, String quality, String file) {
        if (EmptyValidate.emptyValidate(color)) {
            if (EmptyValidate.emptyValidate(kind)) {
                if (EmptyValidate.emptyValidate(size)) {
                    if (QualityValidate.qualityValidate(quality)) {
                        if (EmptyValidate.emptyValidate(file)) {
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
            reset();
            return "true";
        } catch (Exception e) {
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
        String save_project = path_save_file.substring(0, path_save_file.indexOf("target\\"));
        Iterator<String> stringIterator = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(stringIterator.next());
        File file = new File(path_save_file + multipartFile.getOriginalFilename());// đường dẫn lưu trên save
        File fileSave_project = new File(save_project + "src/main/webapp/resources/images/" +
                multipartFile.getOriginalFilename()); // đường dẫn lưu vào thư mục gốc trong dự án
        try {
//            multipartFile.transferTo(fileSave_project);
//            System.out.println("đường dẫn file " + fileSave_project);
            multipartFile.transferTo(file);
            return "true";
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";
    }

    private String findItemsExist(String nameItems, String item) {
        if (!EmptyValidate.emptyValidate(item.trim()) || !EmptyValidate.emptyValidate(nameItems.trim())) {
            return "Please enter input";
        }
        int id; // id of items
        switch (nameItems) {
            case "KIND":
                List<Kind> kindList = manageProductServiceImpl.getAllKind();
                for (Kind k : kindList) {
                    if (k.getNameKind().toUpperCase().equals(item.trim().toUpperCase())) {
                        return "Kind already exist";
                    }
                }
                Kind kind = new Kind();
                kind.setNameKind(item.trim().toUpperCase());
                id = manageProductServiceImpl.addKind(kind);
                return id + "+KIND";

            case "COLOR":
                List<Color> colorList = manageProductServiceImpl.getAllColor();
                for (Color c : colorList) {
                    if (c.getNameColor().trim().toUpperCase().equals(item.trim().toUpperCase())) {
                        return "Color already exist";
                    }
                }
                Color color = new Color();
                color.setNameColor(item.trim().toUpperCase());
                id = manageProductServiceImpl.addColor(color);
                return id + "+COLOR";

            case "SIZE":
                List<Size> sizeList = manageProductServiceImpl.getAllSize();
                int sizeParseInt;
                try {
                    sizeParseInt = Integer.parseInt(item.trim());
                    for (Size s : sizeList) {
                        if (s.getNumber() == sizeParseInt) {
                            return "Size already exist";
                        }
                    }
                    Size size = new Size();
                    size.setNumber(sizeParseInt);
                    id = manageProductServiceImpl.addSize(size);
                    return id + "+SIZE";
                } catch (NumberFormatException e) {
                    return "You enter wrong number format";
                }

            case "PRODUCER":
                List<Producer> producerList = manageProductServiceImpl.getAllProducer();
                String splitName = item.substring(0, item.indexOf("/"));
                String splitAddress = item.substring(item.indexOf("/") + 1);
                if (SpecialCharactersValidate.specialCharactersValidate(splitName) &&
                        SpecialCharactersValidate.specialCharactersValidate(splitAddress)) {
                    for (Producer producer : producerList) {
                        if (producer.getNameProducer().toUpperCase().equals(splitName.toUpperCase())) {
                            return "Name Producer already exist";
                        }
                    }
                    Producer producer1 = new Producer();
                    producer1.setNameProducer(splitName);
                    producer1.setAddress(splitAddress);
                    id = manageProductServiceImpl.addProducer(producer1);
                    return id + "+PRODUCER";
                } else {
                    return "You don't write special characters";
                }
        }
        return null;
    }

    // LƯU item mới
    @PostMapping("saveItem")
    @ResponseBody
    public String saveItem(@RequestParam String header, @RequestParam String item) {
        String subString = header.trim().toUpperCase().substring(7); // do có chữ new trước nên phải cắt
        if (subString.trim().equals("KIND")) {
            return findItemsExist("KIND", item);
        } else if (subString.trim().equals("COLOR")) {
            return findItemsExist("COLOR", item);
        } else if (subString.trim().equals("SIZE")) {
            return findItemsExist("SIZE", item);
        } else {
            return findItemsExist("PRODUCER", item);
        }
    }

    @GetMapping("resetContainer")
    @ResponseBody
    public void reset() {
        this.set.clear();
        this.insertProduct = new Product();
    }

    // delete product
    @PostMapping("deleteProductByID")
    @ResponseBody
    public void deleteProduct(@RequestParam String id) {
        manageProductServiceImpl.deleteProduct(Integer.parseInt(id.trim()));
    }

    // delete product detail
    @PostMapping("deleteProductDetailByID")
    @ResponseBody
    public void deleteProductDetail(@RequestParam String id) {
        manageProductServiceImpl.deleteProductDetail(Integer.parseInt(id.trim()));
    }

    // lấy chi tiết sản phẩm
    @GetMapping("productDetails")
    public String productDetails(@RequestParam int id, ModelMap modelMap) {
        modelMap.addAttribute("infoProduct", detailsProduct(id));
        return "pageDetails";
    }

    @GetMapping("admin-details-product")
    public String adminDetailProduct(ModelMap modelMap, @RequestBody @RequestParam int id) {
        modelMap.addAttribute("infoProductDetails", detailsProduct(id));
        return "editProductAdmin";
    }

    private Product detailsProduct(int id) {
        Product productDetails = manageProductServiceImpl.selectProductById(id);
        return productDetails;
    }

    @PostMapping("UpdateProductDetail")
    @ResponseBody
    public void updateProduct(@RequestParam String idProduct, @RequestParam String idDetail, @RequestParam String quantity,
                              @RequestParam String color, @RequestParam String size, @RequestParam String kind,
                              @RequestParam String nameFile) {
        ProductDetails productDetails = new ProductDetails();
        productDetails.setIdProductDetails(Integer.parseInt(idDetail.trim()));
        productDetails.setQuality(Integer.parseInt(quantity.trim()));

        Product product = new Product();
        product.setIdProduct(Integer.parseInt(idProduct.trim()));
        productDetails.setProduct(product);

        Color setIdColor = new Color();
        setIdColor.setIdColor(Integer.parseInt(color.trim()));
        productDetails.setColor(setIdColor);

        Size setIdSize = new Size();
        setIdSize.setIdSize(Integer.parseInt(size.trim()));
        productDetails.setSize(setIdSize);

        Kind setIdKind = new Kind();
        setIdKind.setIdKind(Integer.parseInt(kind.trim()));
        productDetails.setKind(setIdKind);

        Image setUrlImage = new Image();
        setUrlImage.setPath(nameFile.trim());
        productDetails.setImage(setUrlImage);
        manageProductServiceImpl.updateProductDetail(productDetails);
    }
}
