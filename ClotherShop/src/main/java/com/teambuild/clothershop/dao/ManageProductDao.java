package com.teambuild.clothershop.dao;

import com.teambuild.clothershop.model.Product;

import java.util.List;

public interface ManageProductDao {
    List productList();
    Product selectProductById(int id);

    // get all of table kind, color, size
    List getAllKind();
    List getAllColor();
    List getAllSize();
}
