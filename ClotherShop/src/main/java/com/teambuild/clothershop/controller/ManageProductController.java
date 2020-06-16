package com.teambuild.clothershop.controller;

import com.teambuild.clothershop.model.*;
import com.teambuild.clothershop.serviceimpl.ManageProductServiceImpl;
import com.teambuild.clothershop.serviceimpl.ManageUserServiceImpl;
import com.teambuild.clothershop.utils.GetTimeAndDay;
import com.teambuild.clothershop.validate.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
public class ManageProductController {
    @Autowired
    ManageProductServiceImpl manageProductServiceImpl;

    @Autowired
    ManageUserServiceImpl manageUserServiceImpl;

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
                                   @RequestParam String describe, @RequestParam String producer, @RequestParam String idUser) {
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
                                this.insertProduct.setCodesProduct(code.trim().toUpperCase());
                                this.insertProduct.setNameProduct(name.trim());
                                this.insertProduct.setPrice(Double.parseDouble(price.trim()));
                                this.insertProduct.setDescribeProduct(describe);
                                User user = manageUserServiceImpl.findID(Integer.parseInt(idUser.trim()));
                                this.insertProduct.setUser(user);
                                this.insertProduct.setCreated_time(GetTimeAndDay.getTime());
                                this.insertProduct.setCreated_date(GetTimeAndDay.getDay());
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
                              @RequestParam String quality, @RequestParam String idUser, @RequestParam String file) {
        String check = findProductDetails(color, size, kind, quality, file);
        if (check.equals("true")) {
            // lưu chi tiết sản phẩm vào set
            ProductDetails productDetails = objectProductDetails(color, size, kind, quality, idUser, this.fileName);
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
    public String updateProductAtAdd(@RequestParam String id, @RequestParam String color, @RequestParam String kind,
                                     @RequestParam String size, @RequestParam String quality, @RequestParam String idUser, @RequestParam String file) {
        String check = findProductDetails(color, size, kind, quality, file);
        if (check.equals("true")) {
            int idReal = Integer.parseInt(id) - 1;
            ProductDetails productDetailsNew = objectProductDetails(color, size, kind, quality, idUser, file);
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

    private ProductDetails objectProductDetails(String color, String size, String kind, String quality, String idUser, String image) {
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

        User user = new User();
        user.setIdUser(Integer.parseInt(idUser));

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

    public static String fileName;

    // lưu file vào hệ thống
    @PostMapping("saveAndMoveFile")
    @ResponseBody
    public String moveFile(MultipartHttpServletRequest multipartHttpServletRequest) {
        String path_save_file = context.getRealPath("/resources/images/");
        Iterator<String> stringIterator = multipartHttpServletRequest.getFileNames();
        MultipartFile multipartFile = multipartHttpServletRequest.getFile(stringIterator.next());
        File file = new File(path_save_file + multipartFile.getOriginalFilename());// đường dẫn lưu trên server
        this.fileName = multipartFile.getOriginalFilename();
        try {
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
                if (manageProductServiceImpl.findByItem(item.trim(), "KIND") == null) {
                    Kind kind = new Kind();
                    kind.setNameKind(item.trim().toUpperCase());
                    id = manageProductServiceImpl.addKind(kind);
                    return id + "+KIND";
                } else {
                    return "Kind already exist";
                }
            case "COLOR":
                if (manageProductServiceImpl.findByItem(item.trim(), "COLOR") == null) {
                    Color color = new Color();
                    color.setNameColor(item.trim().toUpperCase());
                    id = manageProductServiceImpl.addColor(color);
                    return id + "+COLOR";
                } else {
                    return "Color already exist";
                }
            case "SIZE":
                try {
                    if (manageProductServiceImpl.findByItem(item.trim(), "SIZE") == null) {
                        Size size = new Size();
                        size.setNumber(Integer.parseInt(item.trim()));
                        id = manageProductServiceImpl.addSize(size);
                        return id + "+SIZE";
                    } else {
                        return "Size already exist";
                    }
                } catch (NumberFormatException e) {
                    return "You enter wrong number format";
                }
            case "PRODUCER":
                String splitName = item.substring(0, item.indexOf("/"));
                String splitAddress = item.substring(item.indexOf("/") + 1);
                System.out.println(splitName + splitAddress);
                if (!SpecialCharactersValidate.specialCharactersValidate(splitName)) {
                    if (manageProductServiceImpl.findByItem(splitName, "PRODUCER") == null) {
                        Producer producer1 = new Producer();
                        producer1.setNameProducer(splitName);
                        producer1.setAddress(splitAddress);
                        id = manageProductServiceImpl.addProducer(producer1);
                        return id + "+PRODUCER";
                    } else {
                        return "Name Producer already existed";
                    }
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
        String subString = header.trim().toUpperCase().substring(7); // do có chữ new trước nên cắt
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
    public String deleteProduct(@RequestParam String id) {
        manageProductServiceImpl.deleteProduct(Integer.parseInt(id.trim()));
        return "true";
    }

    // delete product detail
    @PostMapping("deleteProductDetailByID")
    @ResponseBody
    public void deleteProductDetail(@RequestParam String id) {
        manageProductServiceImpl.deleteProductDetail(Integer.parseInt(id.trim()));
    }

    // update thông tin chính của product
    @PostMapping("updateProductById")
    @ResponseBody
    public String updateProduct(@RequestParam String idProduct, @RequestParam String code, @RequestParam String name,
                              @RequestParam String price, @RequestParam String describe, @RequestParam String producer) {
        Product product = manageProductServiceImpl.selectProductById(Integer.parseInt(idProduct.trim()));
        product.setCodesProduct(code);
        product.setNameProduct(name);
        product.setPrice(Double.parseDouble(price));
        product.setDescribeProduct(describe);
        Producer updateProducer = new Producer();
        updateProducer.setIdProducer(Integer.parseInt(producer.trim()));
        product.setProducer(updateProducer);
        int id = manageProductServiceImpl.updateProductById(product);
        return String.valueOf(id);
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

    @PostMapping("delete-cartdetails")
    public String deleteCartDetails(@RequestParam String idCartDetails) {
        manageProductServiceImpl.deleteCartDetails(Integer.parseInt(idCartDetails.trim()));
        return "true";
    }

    private Product detailsProduct(int id) {
        Product productDetails = manageProductServiceImpl.selectProductById(id);
        return productDetails;
    }

    @PostMapping("UpdateProductDetail")
    @ResponseBody
    public String updateProductDetail(@RequestParam String idDetail, @RequestParam String quantity,
                                @RequestParam String color, @RequestParam String size,
                                @RequestParam String kind) {
        ProductDetails productDetails = manageProductServiceImpl.getProductDetailById(Integer.parseInt(idDetail.trim()));

        productDetails.setQuality(Integer.parseInt(quantity.trim()));

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
        setUrlImage.setPath(this.fileName);
        productDetails.setImage(setUrlImage);
        manageProductServiceImpl.updateProductDetailById(productDetails);
        return "";
    }

    @GetMapping("getAllCartDetailsByIdUser")
    public String getAllCartDetailsByIdUser(ModelMap modelMap, HttpSession session) {
        List<CartDetails> cartDetailsList = null;
        User user = (User)session.getAttribute("userSession");
        if (user != null) {
            Cart cart = manageProductServiceImpl.findIdUserTableCart(user.getIdUser());
            cartDetailsList = manageProductServiceImpl.getAllCartDT(cart);
        }
        modelMap.addAttribute("getAllCartDetailsByIdUser", cartDetailsList);
        return "checkOut";
    }

    @PostMapping("addCart")
    @ResponseBody
    public String addCart(@RequestParam String idProductDetails, @RequestParam String idUser) {
        if (idProductDetails.isEmpty() || idUser.isEmpty()) {
            return "false";
        }
        int parseInt_IdUser = Integer.parseInt(idUser.trim());
        int parseInt_IdProductDetails = Integer.parseInt(idProductDetails.trim());
        ProductDetails productDetails = manageProductServiceImpl.getProductDetailById(parseInt_IdProductDetails);
        Cart idUserInTbCart = manageProductServiceImpl.findIdUserTableCart(parseInt_IdUser);
        if (idUserInTbCart == null) { // if user have not cart -> new cart
            Cart cart = new Cart();
            Set<CartDetails> cartDetailsSet = new HashSet();

            CartDetails cartDetails = new CartDetails();
            cartDetails.setIdProductDetails_CD(productDetails);
            cartDetails.setQuantity(1);
            cartDetails.setPrice(productDetails.getProduct().getPrice());

            User user = manageUserServiceImpl.findID(Integer.parseInt(idUser));
            cart.setIdUser(user);

            cart.setCartDetails(cartDetailsSet);
            cart.setTotalPrice(productDetails.getProduct().getPrice());
            cartDetails.setIdCart_CD(cart);

            cartDetailsSet.add(cartDetails);
            return String.valueOf(manageProductServiceImpl.addCart(cart));
        } else { // if user have cart -> handle table cartDetails
            CartDetails checkIdProductDetails = manageProductServiceImpl.findIdPDTAndIDUSTblCartDT(parseInt_IdProductDetails, idUserInTbCart.getIdCart());
            if (checkIdProductDetails != null) { // update quantity product DT
                CartDetails cartDetails = checkIdProductDetails;
                cartDetails.setQuantity(checkIdProductDetails.getQuantity() + 1);
                manageProductServiceImpl.updateQuantityInProductDT(cartDetails);
            } else { // insert new product DT
                CartDetails cartDetails = new CartDetails();
                cartDetails.setIdCart_CD(idUserInTbCart);
                cartDetails.setPrice(productDetails.getProduct().getPrice());
                cartDetails.setQuantity(1);
                cartDetails.setIdProductDetails_CD(productDetails);
                manageProductServiceImpl.addCartDetails(cartDetails);
            }
            return String.valueOf(manageProductServiceImpl.updatePriceOfCart(idUserInTbCart)); // đang lỗi cập nhập tổng tiền
        }
    }

    @PostMapping("updateQuantityInCartDetails")
    public String updateQuantityInCartDetails(@RequestParam String quantity, @RequestParam String idCartDetails) {
        int idCartDetailsPI = Integer.parseInt(idCartDetails);
        int quantityPI = Integer.parseInt(quantity);
        return String.valueOf(manageProductServiceImpl.updateQuantityInCartDetails(idCartDetailsPI, quantityPI));
    }

    @PostMapping("search-product")
    public String searchProduct(ModelMap modelMap, @RequestParam String search) {
        List<Product> productList = manageProductServiceImpl.searchProduct(search);
        modelMap.addAttribute("listProduct", productList);
        List<Integer> idProductNew = GetTimeAndDay.compareDate(productList);
        modelMap.addAttribute("idProductNew", idProductNew);
        return "searchProduct";
    }
}
