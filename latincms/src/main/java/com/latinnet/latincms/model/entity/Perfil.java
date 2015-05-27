package com.latinnet.latincms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Perfil")
public class Perfil implements BusinessObject{

    private Long id;
    private String descripcion;
    private Usuario usuario;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    public Long getId(){
	return this.id;
    }

    public void setId(Long id){
	this.id = id;
    }

    @Column(name = "descripcion")
    public String getDescripcion(){
	return descripcion;
    }

    public void setDescripcion(String descripcion){
	this.descripcion = descripcion;
    }

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "perfil")
    public Usuario getUsuario(){
	return this.usuario;
    }

    public void setUsuario(Usuario usuario){
	this.usuario = usuario;
    }

}
