package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlagServiceImpl implements FlagService {

    private FlagDao flagDao;


    @Autowired
    public void setFlagDao(FlagDao flagDao) {
        this.flagDao = flagDao;
    }


    @Override
    public Flag get(Integer id) {
        return flagDao.findById(id);
    }


    @Transactional
    @Override
    public Flag save(Flag obj) {
        return flagDao.saveOrUpdate(obj);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        flagDao.delete(id);
    }


    @Override
    public List<Flag> list() {
        return flagDao.findAll();
    }

}
