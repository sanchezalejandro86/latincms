package com.latinnet.latincms.model.entity;

import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name = "Post")
public class Post implements BusinessObject{

    private Long id;
    private String titulo;
    private String contenido;
    private Date fecha;
    private Usuario usuario;
    private Set<Comentario> comentarios = new HashSet<Comentario>();
    
    public Post(){

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

    @Column(name = "titulo")
    public String getTitulo(){
        return titulo;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    @Column(name = "contenido")
    public String getContenido(){
        return contenido;
    }
    
    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    @Temporal(TemporalType.DATE)
    @Column(name = "fecha")
    public Date getFecha(){
        return fecha;
    }

    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    @ManyToOne()
    @JoinColumn(name = "autor_id", nullable = false)
    public Usuario getUsuario(){
        return usuario;
    }

    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "post")
    public Set<Comentario> getComentarios(){
        return comentarios;
    }
    
    public void setComentarios(Set<Comentario> comentarios){
        this.comentarios = comentarios;
    }

}
