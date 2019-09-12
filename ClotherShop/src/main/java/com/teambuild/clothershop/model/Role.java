package com.teambuild.clothershop.model;

import javax.persistence.*;
import java.util.Set;

@Entity(name = "role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idRole;
    private String nameRole;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "idRole_User")
    private Set<User> userSet;

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public String getNameRole() {
        return nameRole;
    }

    public void setNameRole(String nameRole) {
        this.nameRole = nameRole;
    }
}
