package org.academiadecodigo.tailormoons.blue_ocean.services.security;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Common interface for user services
 */
public interface UserService extends UserDetailsService {

    boolean hasUser(String username);

    User add(User user);

    void delete(Integer id);

}
