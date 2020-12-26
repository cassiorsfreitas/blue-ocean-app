package org.academiadecodigo.tailormoons.blue_ocean.services;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagUnderReviewDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class FlagUnderReviewServiceImpl implements FlagUnderReviewService {

    private FlagUnderReviewDao flagUnderReviewDao;


    @Autowired
    public void setFlagUnderReviewDao(FlagUnderReviewDao flagUnderReviewDao) {
        this.flagUnderReviewDao = flagUnderReviewDao;
    }


    @Override
    public FlagUnderReview get(Integer id) {
        return flagUnderReviewDao.findById(id);
    }


    @Transactional
    @Override
    public FlagUnderReview save(FlagUnderReview obj) {
        return flagUnderReviewDao.saveOrUpdate(obj);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        flagUnderReviewDao.delete(id);
    }


    @Override
    public List<FlagUnderReview> list() {
        return flagUnderReviewDao.findAll();
    }

}
