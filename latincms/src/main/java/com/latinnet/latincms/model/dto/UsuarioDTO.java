package com.latinnet.latincms.model.dto;



public class UsuarioDTO{

    private Long id;
    private String username;
    private String password;
    private String nombre;
    private String apellido;
    private String email;
    private PerfilDTO perfil;
    
//    @JsonManagedReference
//    private Set<PostDTO> posts = new HashSet<PostDTO>();
//    @JsonManagedReference("usuario-comentarios")
//    private Set<ComentarioDTO> comentarios = new HashSet<ComentarioDTO>();
    
    public UsuarioDTO(){
    }

    public Long getId(){
	return this.id;
    }

    public void setId(Long id){
	this.id = id;
    }

    public String getUsername(){
	return this.username;
    }

    public void setUsername(String username){
	this.username = username;
    }

    public String getPassword(){
	return this.password;
    }

    public void setPassword(String password){
	this.password = password;
    }

    public String getNombre(){
	return nombre;
    }

    public void setNombre(String nombre){
	this.nombre = nombre;
    }

    public String getApellido(){
	return apellido;
    }

    public void setApellido(String apellido){
	this.apellido = apellido;
    }

    public String getEmail(){
	return email;
    }

    public void setEmail(String email){
	this.email = email;
    }

    public PerfilDTO getPerfil(){
	return this.perfil;
    }

    public void setPerfil(PerfilDTO perfil){
	this.perfil = perfil;
    }

//    public Set<PostDTO> getPosts(){
//        return posts;
//    }
//    
//    public void setPosts(Set<PostDTO> posts){
//        this.posts = posts;
//    }

//    public Set<ComentarioDTO> getComentarios(){
//        return comentarios;
//    }
//    
//    public void setComentarios(Set<ComentarioDTO> comentarios){
//        this.comentarios = comentarios;
//    }
}
