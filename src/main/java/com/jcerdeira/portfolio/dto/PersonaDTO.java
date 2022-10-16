package com.jcerdeira.portfolio.dto;

import javax.validation.constraints.NotBlank;

public class PersonaDTO {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String puestoP;
    @NotBlank
    private String ubicacionP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imgP;

    //Constructores
    public PersonaDTO() {
    }

    public PersonaDTO(String nombreP, String puestoP, String ubicacionP, String descripcionP, String imgP) {
        this.nombreP = nombreP;
        this.puestoP = puestoP;
        this.ubicacionP = ubicacionP;
        this.descripcionP = descripcionP;
        this.imgP = imgP;
    }

    //Getters & Setters
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
