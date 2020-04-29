package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity(name = "product")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProduct;
    private String codesProduct;
    private String nameProduct;
    private String describeProduct;
    private Double price;
    private String updated_date;
    private String updated_time;
    private String created_date;
    private String created_time;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducer_Product")
    private Producer producer;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser_Product")
    private User user; // id user create product

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idProduct_DT")
    private Set<ProductDetails> productDetails = new LinkedHashSet<>();

    public Set<ProductDetails> getProductDetails() {
        return productDetails;
    }

    public void setProductDetails(Set<ProductDetails> productDetails) {
        this.productDetails = productDetails;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getCodesProduct() {
        return codesProduct;
    }

    public void setCodesProduct(String codesProduct) {
        this.codesProduct = codesProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getDescribeProduct() {
        return describeProduct;
    }

    public void setDescribeProduct(String describeProduct) {
        this.describeProduct = describeProduct;
    }

    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUpdated_date() {
        return updated_date;
    }

    public void setUpdated_date(String updated_date) {
        this.updated_date = updated_date;
    }

    public String getUpdated_time() {
        return updated_time;
    }

    public void setUpdated_time(String updated_time) {
        this.updated_time = updated_time;
    }

    public String getCreated_date() {
        return created_date;
    }

    public void setCreated_date(String created_date) {
        this.created_date = created_date;
    }

    public String getCreated_time() {
        return created_time;
    }

    public void setCreated_time(String created_time) {
        this.created_time = created_time;
    }
}
