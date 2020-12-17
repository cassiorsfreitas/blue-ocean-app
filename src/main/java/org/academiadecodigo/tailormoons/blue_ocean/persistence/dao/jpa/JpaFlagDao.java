package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.springframework.stereotype.Repository;

@Repository
public class JpaFlagDao extends GenericJpaDao<Flag> implements FlagDao {

    public JpaFlagDao() {
        super(Flag.class);
    }

}
