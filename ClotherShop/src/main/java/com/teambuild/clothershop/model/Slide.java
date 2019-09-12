package com.teambuild.clothershop.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "slide")
public class Slide {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idSlide;
    private int idUser_Slide;
    private String url;


    public int getIdUser_Slide() {
        return idUser_Slide;
    }

    public void setIdUser_Slide(int idUser_Slide) {
        this.idUser_Slide = idUser_Slide;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getIdSlide() {
        return idSlide;
    }

    public void setIdSlide(int idSlide) {
        this.idSlide = idSlide;
    }
}
