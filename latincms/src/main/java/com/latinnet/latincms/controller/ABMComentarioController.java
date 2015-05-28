package com.latinnet.latincms.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latinnet.latincms.model.dao.PostDAO;

@RequestMapping("/admin/abm/comentarios")
@Controller
public class ABMComentarioController{
    @Autowired
    private PostDAO postDAO;
    
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/layout")
    public String getHomePage(){
	return "abmComentario/index";
    }
    
}
