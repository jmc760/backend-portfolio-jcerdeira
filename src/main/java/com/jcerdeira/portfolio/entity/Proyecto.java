package com.jcerdeira.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Proyecto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String anioP;
    private String descripcionP;
    private String imgP;

    //Constructores
    public Proyecto() {
    }

    public Proyecto(String nombreP, String anioP, String descripcionP, String imgP) {
        this.nombreP = nombreP;
        this.anioP = anioP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }
    
    //Getters & setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreP() {
        return nombreP;
    }

    public void setNombreP(String nombreP) {
        this.nombreP = nombreP;
    }

    public String getAnioP() {
        return anioP;
    }

    public void setAnioP(String anioP) {
        this.anioP = anioP;
    }

    public String getDescripcionP() {
        return descripcionP;
    }

    public void setDescripcionP(String descripcionP) {
        this.descripcionP = descripcionP;
    }

    public String getImgP() {
        return imgP;
    }

    public void setImgP(String imgP) {
        this.imgP = imgP;
    }
    
}
