package com.latinnet.latincms.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin/abm/user")
@Controller
public class ABMUserController{
    
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/layout")
    public String getHomePage(){
    	return "abmUser/index";
    }
    
    @RequestMapping("/nuevo")
    public String getNuevoPage(){
    	return "abmUser/nuevo";
    }
    
}
