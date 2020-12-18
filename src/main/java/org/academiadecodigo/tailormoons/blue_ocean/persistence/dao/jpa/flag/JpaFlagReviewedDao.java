package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa.flag;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagReviewedDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;
import org.springframework.stereotype.Repository;

@Repository
public class JpaFlagReviewedDao extends JpaFlagDao<FlagReviewed> implements FlagReviewedDao {

    public JpaFlagReviewedDao() {
        super(FlagReviewed.class);
    }

}
