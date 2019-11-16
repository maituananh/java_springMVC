package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser; // not null
    private String name; // not null
    private String userName; // not null
    private String password; // not null
    private String phone;
    private String address;
    private String birthday; // not null
    private String hometown;
    private int age;
    private String email; // not null
    private String avatar;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idRole_User")
    private Role role;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idGender_User")
    private Gender gender;

    @OneToOne(fetch = FetchType.EAGER) // chưa sử lý
    @JoinColumn(name = "idVerificationCodes_User")
    private Verification verification;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER) // chưa sử lý
    @JoinColumn(name = "idUser_Product")
    private Set<Product> product = new HashSet<>();

    public Set<Product> getProduct() {
        return product;
    }

    public void setProduct(Set<Product> product) {
        this.product = product;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getHometown() {
        return hometown;
    }

    public void setHometown(String hometown) {
        this.hometown = hometown;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Verification getVerification() {
        return verification;
    }

    public void setVerification(Verification verification) {
        this.verification = verification;
    }
}
