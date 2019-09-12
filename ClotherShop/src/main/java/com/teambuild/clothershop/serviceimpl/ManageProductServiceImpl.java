package com.teambuild.clothershop.serviceimpl;

import com.teambuild.clothershop.daoimpl.ManageProductDaoImpl;
import com.teambuild.clothershop.model.Product;
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
}
