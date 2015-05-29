package com.latinnet.latincms.model.dto;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;


public class ComentarioDTO{
    private Long id;
    private String contenido;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm a z")
    private Date fecha;
    private UsuarioDTO usuario;
    @JsonBackReference
    private PostDTO post;
    private EstadoComentarioDTO estadoComentario;
    
    public ComentarioDTO(){
    }

    public Long getId(){
	return this.id;
    }

    public void setId(Long id){
	this.id = id;
    }

    public String getContenido(){
        return contenido;
    }

    public void setContenido(String contenido){
        this.contenido = contenido;
    }

    public Date getFecha(){
        return fecha;
    }
    
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public UsuarioDTO getUsuario(){
        return usuario;
    }
    
    public void setUsuario(UsuarioDTO usuario){
        this.usuario = usuario;
    }

    public PostDTO getPost(){
        return post;
    }
    
    public void setPost(PostDTO post){
        this.post = post;
    }

    public EstadoComentarioDTO getEstadoComentario(){
        return estadoComentario;
    }
    
    public void setEstadoComentario(EstadoComentarioDTO estadoComentario){
        this.estadoComentario = estadoComentario;
    }
}
