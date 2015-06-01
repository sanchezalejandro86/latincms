package com.latinnet.latincms.controller;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.dozer.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latinnet.latincms.model.dao.PerfilDAO;
import com.latinnet.latincms.model.dao.UsuarioDAO;
import com.latinnet.latincms.model.dto.UsuarioDTO;
import com.latinnet.latincms.model.entity.Post;
import com.latinnet.latincms.model.entity.Usuario;


@RequestMapping("/user")
@Controller
public class UserController{
    
    @Autowired
    private UsuarioDAO usuarioDAO;
    @Autowired
    private PerfilDAO perfilDAO;
    
    @Autowired
    Mapper mapper;
    
    @Transactional
    @ResponseBody
    @RequestMapping("/getAll")
    public List<UsuarioDTO> getAll(){
		List<UsuarioDTO> usuarios = new ArrayList<UsuarioDTO>();
		
		for (Usuario p : usuarioDAO.findAll()){
		    usuarios.add(mapper.map(p, UsuarioDTO.class));
		}
		
		return usuarios;
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/get/{userId}")
	public UsuarioDTO getUser(@PathVariable  Long userId){
		return mapper.map(usuarioDAO.findById(userId), UsuarioDTO.class);
    }
    
    @Transactional
    @ResponseBody
    @RequestMapping("/add")
    public UsuarioDTO addUser(@RequestBody Usuario user){

    	user.setPerfil(perfilDAO.findById(user.getPerfil().getId()));
    	user.setPassword("123");
    	usuarioDAO.save(user);
	
    	return mapper.map(user, UsuarioDTO.class);
    }
    
    
    @Transactional
    @ResponseBody
    @RequestMapping("/delete")
    public void deleteUser(@RequestBody Usuario user){
    	user = usuarioDAO.findById(user.getId());
    	usuarioDAO.delete(user);
    	return ;
    }
    
}
