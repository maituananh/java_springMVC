package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "color")
public class Color {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idColor;
    private String nameColor;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idColor_DT")
    Set<ProductDetails> productDetailsSet;

    public Set<ProductDetails> getProductDetailsSet() {
        return productDetailsSet;
    }

    public void setProductDetailsSet(Set<ProductDetails> productDetailsSet) {
        this.productDetailsSet = productDetailsSet;
    }

    public int getIdColor() {
        return idColor;
    }

    public void setIdColor(int idColor) {
        this.idColor = idColor;
    }

    public String getNameColor() {
        return nameColor;
    }

    public void setNameColor(String nameColor) {
        this.nameColor = nameColor;
    }
}
