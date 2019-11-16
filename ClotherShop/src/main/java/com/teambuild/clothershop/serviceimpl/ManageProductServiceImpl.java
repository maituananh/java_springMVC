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
    public void updateProductDetail(ProductDetails productDetails) {
        manageProductDaoImpl.updateProductDetail(productDetails);
    }

    @Override
    public List recentProducts(int start, int end) {
        return manageProductDaoImpl.recentProducts(start, end);
    }
}
