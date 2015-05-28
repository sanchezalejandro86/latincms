package com.latinnet.latincms.model.dto;


public class TipoPostDTO {

    private Long id;
    private String descripcion;

    public Long getId(){
    	return this.id;
    }

    public void setId(Long id){
    	this.id = id;
    }

    public String getDescripcion(){
    	return descripcion;
    }

    public void setDescripcion(String descripcion){
    	this.descripcion = descripcion;
    }

}