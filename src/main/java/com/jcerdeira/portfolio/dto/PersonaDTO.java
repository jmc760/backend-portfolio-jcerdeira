package com.jcerdeira.portfolio.dto;

import javax.validation.constraints.NotBlank;

public class PersonaDTO {

    @NotBlank
    private String nombreP;
    @NotBlank
    private String puestoP;
    @NotBlank
    private String ubicacionP;

    //Constructores
    public PersonaDTO() {
    }

    public PersonaDTO(String nombreP, String puestoP, String ubicacionP) {
        this.nombreP = nombreP;
        this.puestoP = puestoP;
        this.ubicacionP = ubicacionP;
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

}
