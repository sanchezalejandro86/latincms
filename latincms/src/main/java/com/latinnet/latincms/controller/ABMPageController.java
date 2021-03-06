package com.latinnet.latincms.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latinnet.latincms.model.dao.PostDAO;

@RequestMapping("/admin/abm/page")
@Controller
public class ABMPageController{
    @Autowired
    private PostDAO postDAO;
    
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/layout")
    public String getHomePage(){
    	return "abmPage/index";
    }
    
    @RequestMapping("/nuevo")
    public String getNuevoPage(){
    	return "abmPage/nuevo";
    }
    
}
