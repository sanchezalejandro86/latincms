package com.latinnet.latincms.model.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "Comentario")
public class Comentario implements BusinessObject{
    private Long id;
    private String contenido;
    private Date fecha;
    private Usuario usuario;
    private Post post;
    private EstadoComentario estadoComentario;
    
    public Comentario(){
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

    @ManyToOne
    @JoinColumn(name = "autor_id", nullable = false)
    public Usuario getUsuario(){
        return usuario;
    }
    
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    
    @ManyToOne
    @JoinColumn(name = "post_id", nullable = false)
    public Post getPost(){
        return post;
    }
    
    public void setPost(Post post){
        this.post = post;
    }

    @ManyToOne
    @JoinColumn(name = "estado_comentario_id", nullable = false)
    public EstadoComentario getEstadoComentario(){
        return estadoComentario;
    }
    
    public void setEstadoComentario(EstadoComentario estadoComentario){
        this.estadoComentario = estadoComentario;
    }

}
