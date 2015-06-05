package com.latinnet.latincms.controller;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.latinnet.latincms.model.dao.PerfilDAO;
import com.latinnet.latincms.model.dao.UsuarioDAO;
import com.latinnet.latincms.model.entity.Usuario;

@Controller
public class LoginController{

    @Autowired
    private PerfilDAO perfilDAO;
    @Autowired
    private UsuarioDAO usuarioDAO;

    @RequestMapping("login")
    public String getLoginPage(Model model){
//	if(error != null){
//	    model.addAttribute("error", true);
//	}
	return "login";
    }
    
    @RequestMapping("signup")
    public String getSignUpPage(Model model){
	return "signup";
    }
    
    @Transactional
    @RequestMapping("signup/save")
    public String getSignUpSavePage(@RequestParam String username, @RequestParam String nombre, @RequestParam String apellido ){
	
	Usuario user = new Usuario();
	user.setUsername(username);
	user.setNombre(nombre);
	user.setEmail("");
	user.setApellido(apellido);
	user.setPerfil(perfilDAO.findById(2L));
    	user.setPassword("123");
    	usuarioDAO.save(user);
	
	return "forward:/login";
    }
    
}