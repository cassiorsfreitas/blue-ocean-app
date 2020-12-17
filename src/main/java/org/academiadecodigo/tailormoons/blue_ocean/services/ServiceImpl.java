package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.Dao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@org.springframework.stereotype.Service
public class ServiceImpl<T extends Model> implements Service<T> {

    private Dao<T> dao;

    @Autowired
    public void setDao(Dao<T> dao) {
        this.dao = dao;
    }

    @Override
    public T get(Integer id) {
        return dao.findById(id);
    }

    @Transactional
    @Override
    public T save(T obj) {
        return dao.saveOrUpdate(obj);
    }

    @Transactional
    @Override
    public void delete(Integer id) {
        dao.delete(id);
    }

    @Override
    public List<T> list() {
        return dao.findAll();
    }
}
