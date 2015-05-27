package com.latinnet.latincms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/admin")
@Controller
public class AdminController{

    @RequestMapping("/layout")
    public String getAdminPage(){
	return "admin";
    }
}
