package org.academiadecodigo.tailormoons.teamslack.persistence.dao.security;

import org.academiadecodigo.tailormoons.teamslack.persistence.model.security.Role;

/**
 * Common interface for role data access objects
 */
public interface RoleDao {

    /**
     * Gets the role of the given name
     *
     * @param name the name
     * @return the role
     */
    Role findByName(String name);
}
