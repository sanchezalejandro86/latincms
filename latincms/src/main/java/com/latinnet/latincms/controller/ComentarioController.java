package com.latinnet.latincms.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latinnet.latincms.model.dao.ComentarioDAO;
import com.latinnet.latincms.model.dao.EstadoComentarioDAO;
import com.latinnet.latincms.model.dao.PostDAO;
import com.latinnet.latincms.model.dao.UsuarioDAO;
import com.latinnet.latincms.model.dto.ComentarioDTO;
import com.latinnet.latincms.model.entity.Comentario;

@RequestMapping("/comentario")
@Controller
public class ComentarioController{
    
    @Autowired
    private ComentarioDAO comentarioDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private EstadoComentarioDAO estadoComentarioDAO;
    
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/layout")
    public String getHomePage(){
	return "comentarios";
    }
 
    @Transactional
    @ResponseBody
    @RequestMapping("/add")
    public ComentarioDTO addComentario(@RequestBody Comentario comentario){
	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	comentario.setUsuario(usuarioDAO.findByUserName(user.getUsername()));
	comentario.setPost(postDAO.findById(comentario.getPost().getId()));
	comentario.setEstadoComentario(estadoComentarioDAO.findById(1L));
	comentario.setFecha(new Date());

	comentarioDAO.save(comentario);
	
	return mapper.map(comentario, ComentarioDTO.class);
    }
    
    
    @Transactional
    @ResponseBody
    @RequestMapping("/getAll")
    public List<ComentarioDTO> getAll(){
	List<ComentarioDTO> comentarios = new ArrayList<ComentarioDTO>();
	
	for (Comentario  p : comentarioDAO.findAll()){
	    comentarios.add(mapper.map(p, ComentarioDTO.class));
	}
	
	return comentarios;
    }
    
}