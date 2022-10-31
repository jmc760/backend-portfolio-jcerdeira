package com.jcerdeira.portfolio.dto;

import javax.validation.constraints.NotBlank;

public class SkillDTO {

    @NotBlank
    private String nombreS;
    @NotBlank
    private int porcentajeS;
    @NotBlank
    private String imgS;

    public SkillDTO() {
    }

    public SkillDTO(String nombreS, int porcentajeS, String imgS) {
        this.nombreS = nombreS;
        this.porcentajeS = porcentajeS;
        this.imgS = imgS;
    }

    public String getNombreS() {
        return nombreS;
    }

    public void setNombreS(String nombreS) {
        this.nombreS = nombreS;
    }

    public int getPorcentajeS() {
        return porcentajeS;
    }

    public void setPorcentajeS(int porcentajeS) {
        this.porcentajeS = porcentajeS;
    }

    public String getImgS() {
        return imgS;
    }

    public void setImgS(String imgS) {
        this.imgS = imgS;
    }

}
