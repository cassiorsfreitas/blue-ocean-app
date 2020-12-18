package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagReviewedDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlagReviewedServiceImpl implements FlagReviewedService {

    private FlagReviewedDao flagReviewedDao;


    @Autowired
    public void setFlagReviewedDao(FlagReviewedDao flagReviewedDao) {
        this.flagReviewedDao = flagReviewedDao;
    }


    @Override
    public FlagReviewed get(Integer id) {
        return flagReviewedDao.findById(id);
    }


    @Transactional
    @Override
    public FlagReviewed save(FlagReviewed obj) {
        return flagReviewedDao.saveOrUpdate(obj);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        flagReviewedDao.delete(id);
    }


    @Override
    public List<FlagReviewed> list() {
        return flagReviewedDao.findAll();
    }

}
