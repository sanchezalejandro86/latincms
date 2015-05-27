package com.latinnet.latincms.model.dao;

import java.io.Serializable;
import java.util.List;

import com.latinnet.latincms.model.entity.BusinessObject;

public interface IGenericDAO<Entity extends BusinessObject, PK extends Serializable>{

    Entity save(Entity model);

    Entity findById(PK id);
    
    List<Entity> findAll();

    void delete(Entity model);
}
