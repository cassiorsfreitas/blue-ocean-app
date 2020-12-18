package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa.flag;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.FlagDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.jpa.GenericJpaDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;

public abstract class JpaFlagDao<T extends Flag> extends GenericJpaDao<T> implements FlagDao<T> {

    public JpaFlagDao(Class<T> modelType) {
        super(modelType);
    }

}
