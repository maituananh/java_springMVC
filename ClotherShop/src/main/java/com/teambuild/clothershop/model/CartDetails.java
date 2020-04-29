package com.teambuild.clothershop.model;

import javax.persistence.*;

@Entity(name = "cartdetails")
public class CartDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCartDetails;

    @OneToOne (fetch = FetchType.EAGER)
    @JoinColumn(name = "idCart_CD")
    private Cart idCart_CD;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idProductDetails_CD")
    private ProductDetails idProductDetails_CD;

    private double price;

    private int quantity;

    public int getIdCartDetails() {
        return idCartDetails;
    }

    public void setIdCartDetails(int idCartDetails) {
        this.idCartDetails = idCartDetails;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Cart getIdCart_CD() {
        return idCart_CD;
    }

    public void setIdCart_CD(Cart idCart_CD) {
        this.idCart_CD = idCart_CD;
    }

    public ProductDetails getIdProductDetails_CD() {
        return idProductDetails_CD;
    }

    public void setIdProductDetails_CD(ProductDetails idProductDetails_CD) {
        this.idProductDetails_CD = idProductDetails_CD;
    }
}
