package com.latinnet.latincms.model.dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.latinnet.latincms.model.entity.BusinessObject;


public class AbstractHibernateDAO<Entity extends BusinessObject, PK extends Serializable> implements IGenericDAO<Entity, PK>{

    private Log log = LogFactory.getLog(AbstractHibernateDAO.class);

    public Class<Entity> domainClass = getDomainClass();

    @Autowired
    protected SessionFactory sessionFactory;

    public SessionFactory getSessionFactory(){

	return sessionFactory;
    }

    public void setSessionFactory(SessionFactory sessionFactory){

	this.sessionFactory = sessionFactory;
    }

    public Entity save(Entity model){

	sessionFactory.getCurrentSession().saveOrUpdate(model);
	log.info("Entity saved with id: " + model.getId());
	return model;
    }

    public Entity findById(PK id){
	return (Entity) sessionFactory.getCurrentSession().load(domainClass, id);
    }

    public List<Entity> findAll(){

	return (List<Entity>) sessionFactory.getCurrentSession().createQuery("from " + this.domainClass.getName()).list();
    }

    public void delete(Entity model){

	sessionFactory.getCurrentSession().delete(model);
	log.info("Contact deleted with id: " + model.getId());
    }

    protected Class getDomainClass(){

	if (domainClass == null){
	    ParameterizedType thisType = (ParameterizedType) getClass().getGenericSuperclass();
	    domainClass = (Class) thisType.getActualTypeArguments()[0];
	}
	return domainClass;
    }
}
