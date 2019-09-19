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
    public List productList() {
        return manageProductDaoImpl.productList();
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
    public void addKind(Kind kind) {
        manageProductDaoImpl.addKind(kind);
    }

    @Override
    public void addColor(Color color) {
        manageProductDaoImpl.addColor(color);
    }

    @Override
    public void addSize(Size size) {
        manageProductDaoImpl.addSize(size);
    }

    @Override
    public void addProducer(Producer producer) {
        manageProductDaoImpl.addProducer(producer);
    }
}
