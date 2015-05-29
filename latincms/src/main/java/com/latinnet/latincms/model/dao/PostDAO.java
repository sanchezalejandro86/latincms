package com.latinnet.latincms.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.latinnet.latincms.model.entity.Post;
import com.latinnet.latincms.model.entity.TipoPost;

@Repository
public class PostDAO extends AbstractHibernateDAO<Post, Long>{

	public List<Post> findAllByTipo(TipoPost tipoPost) {
		return (List<Post>) sessionFactory.getCurrentSession().createQuery("from Post where tipoPost = :tipo order by fecha desc").setParameter("tipo", tipoPost).list();
	}
}
