package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa.flag;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagUnderReviewDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.springframework.stereotype.Repository;

@Repository
public class JpaFlagUnderReviewDaoDao extends JpaFlagDao<FlagUnderReview> implements FlagUnderReviewDao {


    public JpaFlagUnderReviewDaoDao() {
        super(FlagUnderReview.class);
    }

}
