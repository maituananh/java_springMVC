package com.teambuild.clothershop.model;

import javax.persistence.*;

@Entity(name = "productdetails")
public class ProductDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProductDetails;
    private int idProduct_DT;
    private int quality;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idSize_DT")
    private Size size;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idColor_DT")
    private Color color;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idKind_DT")
    private Kind kind;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idImage_DT")
    private Image image;

    public int getIdProductDetails() {
        return idProductDetails;
    }

    public void setIdProductDetails(int idProductDetails) {
        this.idProductDetails = idProductDetails;
    }

    public int getIdProduct_DT() {
        return idProduct_DT;
    }

    public void setIdProduct_DT(int idProduct_DT) {
        this.idProduct_DT = idProduct_DT;
    }

    public Size getSize() {
        return size;
    }

    public void setSize(Size size) {
        this.size = size;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Kind getKind() {
        return kind;
    }

    public void setKind(Kind kind) {
        this.kind = kind;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}
