package com.teambuild.clothershop.dao;

import com.teambuild.clothershop.model.*;

import java.util.List;

public interface ManageProductDao {
    List productList();
    Product selectProductById(int id);
    void insertProduct(Product product);

    // get all of table kind, color, size
    List getAllKind();
    List getAllColor();
    List getAllSize();
    List getAllProducer();

    void addKind(Kind kind);
    void addColor(Color color);
    void addSize(Size size);
    void addProducer(Producer producer);
}
