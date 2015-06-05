package com.latinnet.latincms.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latinnet.latincms.model.dao.UsuarioDAO;


@RequestMapping("/profile")
@Controller
public class ProfileController{
    
    @Autowired
    private UsuarioDAO usuarioDAO;

    @Autowired
    Mapper mapper;
    
    @RequestMapping("/layout")
    public String getHomePage(){
	return "miPerfil/index";
    }
    
}
