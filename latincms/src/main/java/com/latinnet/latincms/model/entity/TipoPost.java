package com.latinnet.latincms.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Tipo_Post")
public class TipoPost implements BusinessObject{

    private Long id;
    private String descripcion;

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

}