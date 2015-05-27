package com.latinnet.latincms.model.dto;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonManagedReference;

public class PostDTO{

    private Long id;
    private String titulo;
    private String contenido;
    private Date fecha;
    @JsonManagedReference
    private Set<ComentarioDTO> comentarios = new HashSet<ComentarioDTO>();
    private TipoPostDTO tipoPost; 
    private UsuarioDTO usuario; 
    
    public PostDTO(){
    }

    public Long getId(){
	return this.id;
    }

    public void setId(Long id){
	this.id = id;
    }

    public String getTitulo(){
        return titulo;
    }
    
    public void setTitulo(String titulo){
        this.titulo = titulo;
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

    public Set<ComentarioDTO> getComentarios(){
        return comentarios;
    }
    
    public void setComentarios(Set<ComentarioDTO> comentarios){
        this.comentarios = comentarios;
    }

    public TipoPostDTO getTipoPost() {
		return tipoPost;
	}

	public void setTipoPost(TipoPostDTO tipoPost) {
		this.tipoPost = tipoPost;
	}

	public UsuarioDTO getUsuario(){
        return usuario;
    }
    
    public void setUsuario(UsuarioDTO usuario){
        this.usuario = usuario;
    }
    
}
