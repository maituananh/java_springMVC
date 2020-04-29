package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "producer")
public class Producer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idProducer;
    private String nameProducer;
    private String address;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idProducer_Product")
    private Set<Product> productSet;

    public int getIdProducer() {
        return idProducer;
    }

    public void setIdProducer(int idProducer) {
        this.idProducer = idProducer;
    }

    public Set<Product> getProductSet() {
        return productSet;
    }

    public void setProductSet(Set<Product> productSet) {
        this.productSet = productSet;
    }

    public String getNameProducer() {
        return nameProducer;
    }

    public void setNameProducer(String nameProducer) {
        this.nameProducer = nameProducer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
