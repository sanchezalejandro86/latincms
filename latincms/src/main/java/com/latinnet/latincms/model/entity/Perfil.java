package com.latinnet.latincms.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Perfil")
public class Perfil implements BusinessObject{

    private Long id;
    private String descripcion;
    private Set<Usuario> usuarios = new HashSet<Usuario>();

    public Perfil() {
	}
    
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "perfil")
    public Set<Usuario> getUsuarios(){
	return this.usuarios;
    }

    public void setUsuarios(Set<Usuario> usuarios){
	this.usuarios = usuarios;
    }

}
