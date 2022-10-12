package com.jcerdeira.portfolio.dto;

import javax.validation.constraints.NotBlank;

public class ExperienciaDTO {

    @NotBlank
    private String nombreE;
    @NotBlank
    private String descripcionE;

    //Constructores
    public ExperienciaDTO() {
    }

    public ExperienciaDTO(String nombreE, String descripcionE) {
        this.nombreE = nombreE;
        this.descripcionE = descripcionE;
    }
    
    //Getters & Setters

    public String getNombreE() {
        return nombreE;
    }

    public void setNombreE(String nombreE) {
        this.nombreE = nombreE;
    }

    public String getDescripcionE() {
        return descripcionE;
    }

    public void setDescripcionE(String descripcionE) {
        this.descripcionE = descripcionE;
    }

}