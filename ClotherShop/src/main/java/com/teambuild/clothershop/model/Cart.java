package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "cart")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idCart;

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "idUser")
    private User User;

    private double totalPrice;

    @OneToMany(fetch = FetchType.EAGER)
    @JoinColumn(name = "idCart_CD")
    private Set<CartDetails> cartDetails = new HashSet<>();

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public User getUser() {
        return User;
    }

    public void setIdUser(User User) {
        this.User = User;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Set<CartDetails> getCartDetails() {
        return cartDetails;
    }

    public void setCartDetails(Set<CartDetails> cartDetails) {
        this.cartDetails = cartDetails;
    }
}
