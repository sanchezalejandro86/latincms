package com.latinnet.latincms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.latinnet.latincms.model.DatosLogin;

@Controller
public class LoginController{

    @RequestMapping("ingresar")
    public String login(DatosLogin datos, Model model){
	return "home";
    }
    
    @RequestMapping("login")
    public String getLoginPage(Model model){
//	if(error != null){
//	    model.addAttribute("error", true);
//	}
	return "login";
    }
    
}