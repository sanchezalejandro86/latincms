package com.latinnet.latincms.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "Usuario")
public class Usuario implements BusinessObject{

    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private Perfil perfil;
    
    private Set<Post> posts = new HashSet<Post>();
    private Set<Comentario> comentarios = new HashSet<Comentario>();
    
    public Usuario(){
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

    @Column(name = "username", unique = true, nullable = false, length = 45)
    public String getUsername(){
	return this.username;
    }

    public void setUsername(String username){
	this.username = username;
    }

    @Column(name = "password", nullable = false, length = 60)
    public String getPassword(){
	return this.password;
    }

    public void setPassword(String password){
	this.password = password;
    }

    @Column(name = "nombre", nullable = false, length = 60)
    public String getNombre(){
	return nombre;
    }

    public void setNombre(String nombre){
	this.nombre = nombre;
    }

    @Column(name = "apellido", nullable = false, length = 60)
    public String getApellido(){
	return apellido;
    }

    public void setApellido(String apellido){
	this.apellido = apellido;
    }

    @Column(name = "email", nullable = false, length = 60)
    public String getEmail(){
	return email;
    }

    public void setEmail(String email){
	this.email = email;
    }

    @ManyToOne
    @JoinColumn(name = "perfil_id", nullable = false)
    public Perfil getPerfil(){
	return this.perfil;
    }

    public void setPerfil(Perfil perfil){
	this.perfil = perfil;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Post> getPosts(){
        return posts;
    }
    
    public void setPosts(Set<Post> posts){
        this.posts = posts;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
    public Set<Comentario> getComentarios(){
        return comentarios;
    }
    
    public void setComentarios(Set<Comentario> comentarios){
        this.comentarios = comentarios;
    }
}
