package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Model;

import java.util.List;

public interface Service<T extends Model> {

    T get(Integer id);

    T save(T obj);

    void delete(Integer id);

    List<T> list();

}
