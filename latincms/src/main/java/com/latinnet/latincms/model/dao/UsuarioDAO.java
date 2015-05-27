package com.latinnet.latincms.model.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.latinnet.latincms.model.entity.Usuario;

@Repository
public class UsuarioDAO extends AbstractHibernateDAO<Usuario, Long>{

    @SuppressWarnings("unchecked")
    public Usuario findByUserName(String username){

	List<Usuario> users = new ArrayList<Usuario>();

	users = sessionFactory.getCurrentSession().createQuery("from Usuario where username=?")
				.setParameter(0, username).list();

	if (users.size() > 0){
	    return users.get(0);
	}else{
	    return null;
	}

    }
}
