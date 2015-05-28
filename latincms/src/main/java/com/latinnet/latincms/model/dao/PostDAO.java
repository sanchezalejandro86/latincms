package com.latinnet.latincms.model.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.latinnet.latincms.model.entity.Post;

@Repository
public class PostDAO extends AbstractHibernateDAO<Post, Long>{

	@Override
	public List<Post> findAll() {
		return (List<Post>) sessionFactory.getCurrentSession().createQuery("from Post order by fecha desc").list();
	}
}
