package com.latinnet.latincms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latinnet.latincms.model.dao.PostDAO;
import com.latinnet.latincms.model.dto.PostDTO;
import com.latinnet.latincms.model.entity.Post;


@RequestMapping("/post")
@Controller
public class PostController{
    
    @Autowired
    private PostDAO postDAO;
    
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
	
	for (Post  p : postDAO.findAll()){
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
    
}
