package com.jcerdeira.portfolio.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Persona {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombreP;
    private String puestoP;
    private String ubicacionP;


    //Constructores
    public Persona() {
    }

    public Persona(String nombreP, String puestoP, String ubicacionP) {
        this.nombreP = nombreP;
        this.puestoP = puestoP;
        this.ubicacionP = ubicacionP;
    }

    //Getters and setters
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

    public String getPuestoP() {
        return puestoP;
    }

    public void setPuestoP(String puestoP) {
        this.puestoP = puestoP;
    }

    public String getUbicacionP() {
        return ubicacionP;
    }

    public void setUbicacionP(String ubicacionP) {
        this.ubicacionP = ubicacionP;
    }

}
