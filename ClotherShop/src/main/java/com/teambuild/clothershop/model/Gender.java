package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "gender")
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idGender;
    private String nameGender;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idGender_User")
    private Set<User> userSet;

    public int getIdGender() {
        return idGender;
    }

    public void setIdGender(int idGender) {
        this.idGender = idGender;
    }

    public String getNameGender() {
        return nameGender;
    }

    public void setNameGender(String nameGender) {
        this.nameGender = nameGender;
    }
}
