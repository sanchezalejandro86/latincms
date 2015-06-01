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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latinnet.latincms.model.dao.PostDAO;
import com.latinnet.latincms.model.dao.TipoPostDAO;
import com.latinnet.latincms.model.dao.UsuarioDAO;
import com.latinnet.latincms.model.dto.NodeDTO;
import com.latinnet.latincms.model.dto.PostDTO;
import com.latinnet.latincms.model.entity.Post;


@RequestMapping("/post")
@Controller
public class PostController{
    
    @Autowired
    private PostDAO postDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private TipoPostDAO tipoPostDAO;
    
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/layout")
    public String getHomePage(){
	return "post";
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/getAll")
    public List<PostDTO> getAll(){
	List<PostDTO> posts = new ArrayList<PostDTO>();
	
	for (Post  p : postDAO.findAllByTipo(tipoPostDAO.findById(1L))){
	    posts.add(mapper.map(p, PostDTO.class));
	}
	
	return posts;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/get/{postId}")
    public PostDTO getPost(@PathVariable  Long postId){
	return mapper.map(postDAO.findById(postId), PostDTO.class);
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/add")
    public PostDTO addPost(@RequestBody Post post){
	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	post.setUsuario(usuarioDAO.findByUserName(user.getUsername()));
	post.setTipoPost(tipoPostDAO.findById(1L));
	post.setFecha(new Date());

	postDAO.save(post);
	
	return mapper.map(post, PostDTO.class);
    }
    
    
    @Transactional
    @ResponseBody
    @RequestMapping("/delete")
    public void deletePost(@RequestBody Post post){
    	post = postDAO.findById(post.getId());
    	postDAO.delete(post);
    	return ;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/getYears")
    public List<NodeDTO> getYears(){
	List<NodeDTO> anios = new ArrayList<NodeDTO>();
	
	anios.add(new NodeDTO("2015", 1));
	anios.add(new NodeDTO("2014", 1));
	anios.add(new NodeDTO("2013", 1));
	
	return anios;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/getMonths/{year}")
    public List<NodeDTO> getMonth(@PathVariable int year){
	List<NodeDTO> meses = new ArrayList<NodeDTO>();
	
	meses.add(new NodeDTO("Marzo", 2));
	meses.add(new NodeDTO("Abril", 2));
	meses.add(new NodeDTO("Mayo", 2));
	
	return meses;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/getPostsByMonth/{month}")
    public List<NodeDTO> getMonths(@PathVariable String month){
	List<NodeDTO> titulos = new ArrayList<NodeDTO>();
	List<PostDTO> posts = this.getAll();
	for (PostDTO p : posts){
	    titulos.add(new NodeDTO(p.getTitulo(), 3));
	}
	return titulos;
    }
}
