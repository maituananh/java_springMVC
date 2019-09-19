package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "size")
public class Size {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSize;
    private int number;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idSize_DT")
    Set<ProductDetails> productDetailsSet;

    public Set<ProductDetails> getProductDetailsSet() {
        return productDetailsSet;
    }

    public void setProductDetailsSet(Set<ProductDetails> productDetailsSet) {
        this.productDetailsSet = productDetailsSet;
    }

    public int getIdSize() {
        return idSize;
    }

    public void setIdSize(int idSize) {
        this.idSize = idSize;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
