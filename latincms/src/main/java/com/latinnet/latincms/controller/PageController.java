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
import com.latinnet.latincms.model.dto.PostDTO;
import com.latinnet.latincms.model.entity.Post;


@RequestMapping("/page")
@Controller
public class PageController{
    
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
	
	for (Post  p : postDAO.findAllByTipo(tipoPostDAO.findById(2L))){
	    posts.add(mapper.map(p, PostDTO.class));
	}
	
	return posts;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/get/{pageId}")
    public PostDTO getPost(@PathVariable  Long postId){
	return mapper.map(postDAO.findById(postId), PostDTO.class);
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/add")
    public PostDTO addPage(@RequestBody Post post){
	User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

	post.setUsuario(usuarioDAO.findByUserName(user.getUsername()));
	post.setTipoPost(tipoPostDAO.findById(2L));
	post.setFecha(new Date());

	postDAO.save(post);
	
	return mapper.map(post, PostDTO.class);
    }
    
    
    @Transactional
    @ResponseBody
    @RequestMapping("/delete")
    public void deletePage(@RequestBody Post post){
    	post = postDAO.findById(post.getId());
    	postDAO.delete(post);
    	return ;
    }
    
}
