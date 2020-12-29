package org.academiadecodigo.tailormoons.blue_ocean.services.security;

import org.academiadecodigo.tailormoons.blue_ocean.dto.RegisterCustomerDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * Common interface for user services
 */
public interface UserService extends UserDetailsService {

    boolean hasUser(String username);

    boolean hasUser(Integer id);

    User get(Integer id);

    User add(RegisterCustomerDto registerCustomerDto);

    void delete(Integer id);

    void resetPassword(Integer id);

    void updateRole(Integer id, String role);

}
