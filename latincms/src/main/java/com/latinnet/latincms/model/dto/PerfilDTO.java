package com.latinnet.latincms.model.dto;


public class PerfilDTO{
    private Long id;
    private String descripcion;
//    @JsonBackReference
    //private UsuarioDTO usuario;

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

//    public UsuarioDTO getUsuario(){
//	return this.usuario;
//    }
//
//    public void setUsuario(UsuarioDTO usuario){
//	this.usuario = usuario;
//    }
}
