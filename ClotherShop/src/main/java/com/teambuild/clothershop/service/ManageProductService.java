package com.teambuild.clothershop.service;

import com.teambuild.clothershop.model.*;

import java.util.List;

public interface ManageProductService {
    List productList(int position, int page);
    List getAllProduct();
    Product selectProductById(int id);
    void insertProduct(Product product);
    int updateProductById(Product product);
    // get all of table kind, color, size
    List getAllKind();
    List getAllColor();
    List getAllSize();
    List getAllProducer();
    Object findByItem(String nameItem, String typeItem);

    int addKind(Kind kind);
    int addColor(Color color);
    int addSize(Size size);
    int addProducer(Producer producer);

    void deleteProduct(int id);
    void deleteProductDetail(int id);
    ProductDetails getProductDetailById(int id);
    void updateProductDetailById(ProductDetails productDetails);

    List recentProducts(int start, int end);

    List getAllCart();
    List getAllCartDT(Cart cart);
    int addCart(Cart cart);
    Cart findIdUserTableCart(int idUser);
    CartDetails findIdPDTAndIDUSTblCartDT(int idProductDT, int idCartCD);
    int updateQuantityInProductDT(CartDetails cartDetails);
    int addCartDetails(CartDetails cartDetails);
    Long sumPriceInCartDetails(Cart cart);
    int updatePriceOfCart(Cart cart);
    int deleteCartDetails(int idCartDetails);
    int updateQuantityInCartDetails(int idCartDetails, int quantity);
    List<Product> searchProduct(String nameProduct);
}
