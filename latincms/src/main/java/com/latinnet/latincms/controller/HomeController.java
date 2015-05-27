package com.latinnet.latincms.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latinnet.latincms.model.dao.PostDAO;


@Controller
public class HomeController{
    
    @Autowired
    private PostDAO postDAO;
    
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/")
    public String getIndexPage(){
    	return "index";
    }
    
    @RequestMapping("/home/layout")
    public String getHomePage(){
	return "home";
    }
    
}
