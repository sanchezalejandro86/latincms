package com.latinnet.latincms.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.latinnet.latincms.model.dao.UsuarioDAO;
import com.latinnet.latincms.model.entity.Perfil;
import com.latinnet.latincms.model.entity.Usuario;

@Service("myUserDetailsService")
public class MyUserDetailsService implements UserDetailsService {
    
	//get user from the database, via Hibernate
	@Autowired
	private UsuarioDAO userDao;

	@Transactional
	public UserDetails loadUserByUsername(final String username) throws UsernameNotFoundException {

		Usuario user = userDao.findByUserName(username);
		List<GrantedAuthority> authorities = buildUserAuthority(user.getPerfil());

		return buildUserForAuthentication(user, authorities);

	}

	private User buildUserForAuthentication(Usuario user, List<GrantedAuthority> authorities) {
		return new User(user.getUsername(), user.getPassword(), true, true, true, true, authorities);
	}

	private List<GrantedAuthority> buildUserAuthority(Perfil perfil) {

		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();

		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority("ROLE_USER"/*perfil.getDescripcion()*/));

		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(setAuths);

		return Result;
	}

}