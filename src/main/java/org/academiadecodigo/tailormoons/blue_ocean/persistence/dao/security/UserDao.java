package org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.Dao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;

/**
 * Common interface for user costumer data access objects
 */
public interface UserDao extends Dao<User> {

    /**
     * Gets the user of the given username
     *
     * @param username the username
     * @return the user
     */
    User findByName(String username);

    /**
     * Saves or updates the user
     *
     * @param user the user to be saved or updated
     * @return the saved or updated user
     */
    User saveOrUpdate(User user);
}
