package com.teambuild.clothershop.dao;

import com.teambuild.clothershop.model.*;

import java.util.List;

public interface ManageProductDao {
    List productList(int position, int page);
    List getAllProduct();
    Product selectProductById(int id);
    void insertProduct(Product product);

    // get all of table kind, color, size
    List getAllKind();
    List getAllColor();
    List getAllSize();
    List getAllProducer();

    // return id of items
    int addKind(Kind kind);
    int addColor(Color color);
    int addSize(Size size);
    int addProducer(Producer producer);

    List recentProducts(int start, int end);
}
