package com.teambuild.clothershop.serviceimpl;

import com.teambuild.clothershop.daoimpl.ManageProductDaoImpl;
import com.teambuild.clothershop.model.*;
import com.teambuild.clothershop.service.ManageProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ManageProductServiceImpl implements ManageProductService {

    @Autowired
    ManageProductDaoImpl manageProductDaoImpl;

    @Override
    public List productList(int position, int page) {
        return manageProductDaoImpl.productList(position, page);
    }

    @Override
    public List getAllProduct() {
        return manageProductDaoImpl.getAllProduct();
    }

    @Override
    public Product selectProductById(int id) {
        return manageProductDaoImpl.selectProductById(id);
    }

    @Override
    public void insertProduct(Product product) {
        manageProductDaoImpl.insertProduct(product);
    }

    @Override
    public List getAllKind() {
        return manageProductDaoImpl.getAllKind();
    }

    @Override
    public List getAllColor() {
        return manageProductDaoImpl.getAllColor();
    }

    @Override
    public List getAllSize() {
        return manageProductDaoImpl.getAllSize();
    }

    @Override
    public List getAllProducer() {
        return manageProductDaoImpl.getAllProducer();
    }

    @Override
    public int addKind(Kind kind) {
        return manageProductDaoImpl.addKind(kind);
    }

    @Override
    public int addColor(Color color) {
        return manageProductDaoImpl.addColor(color);
    }

    @Override
    public int addSize(Size size) {
        return manageProductDaoImpl.addSize(size);
    }

    @Override
    public int addProducer(Producer producer) {
        return manageProductDaoImpl.addProducer(producer);
    }

    @Override
    public void deleteProduct(int id) {
        manageProductDaoImpl.deleteProduct(id);
    }

    @Override
    public void deleteProductDetail(int id) {
        manageProductDaoImpl.deleteProductDetail(id);
    }

    @Override
    public ProductDetails getProductDetailById(int id) {
        return manageProductDaoImpl.getProductDetailById(id);
    }

    @Override
    public void updateProductDetailById(ProductDetails productDetails) {
        manageProductDaoImpl.updateProductDetailById(productDetails);
    }

    @Override
    public List recentProducts(int start, int end) {
        return manageProductDaoImpl.recentProducts(start, end);
    }

    @Override
    public Object findByItem(String nameItem, String typeItem) {
        return manageProductDaoImpl.findByItem(nameItem, typeItem);
    }

    @Override
    public List getAllCart() {
        return manageProductDaoImpl.getAllCart();
    }

    @Override
    public List getAllCartDT(CartDetails cartDetails) {
        return manageProductDaoImpl.getAllCartDT(cartDetails);
    }

    @Override
    public int addCart(Cart cart) {
        return manageProductDaoImpl.addCart(cart);
    }

    @Override
    public Cart findIdUserTableCart(int idUser) {
        return manageProductDaoImpl.findIdUserTableCart(idUser);
    }

    @Override
    public CartDetails findIdPDTAndIDUSTblCartDT(int idProductDT, int idCartCD) {
        return manageProductDaoImpl.findIdPDTAndIDUSTblCartDT(idProductDT, idCartCD);
    }

    @Override
    public int updateQuantityInProductDT(CartDetails cartDetails) {
        return manageProductDaoImpl.updateQuantityInProductDT(cartDetails);
    }

    @Override
    public int addCartDetails(CartDetails cartDetails) {
        return manageProductDaoImpl.addCartDetails(cartDetails);
    }

    @Override
    public Long sumPriceInCartDetails(Cart cart) {
        return manageProductDaoImpl.sumPriceInCartDetails(cart);
    }

    @Override
    public int updatePriceOfCart(Cart cart) {
        return manageProductDaoImpl.updatePriceOfCart(cart);
    }
}
