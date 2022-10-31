package com.jcerdeira.portfolio.dto;

import javax.validation.constraints.NotBlank;

public class ProyectoDTO {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String anioP;
    @NotBlank
    private String descripcionP;
    @NotBlank
    private String imgP;

    //Constructores
    public ProyectoDTO() {
    }

    public ProyectoDTO(String nombreP, String anioP, String descripcionP, String imgP) {
        this.nombreP = nombreP;
        this.anioP = anioP;
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
