package com.latinnet.latincms.controller;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class AboutController{
    @Autowired
    Mapper mapper;
    
    @RequestMapping("/about/layout")
    public String getHomePage(){
	return "about";
    }
    
}
