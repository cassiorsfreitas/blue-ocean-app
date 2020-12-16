package org.academiadecodigo.tailormoons.teamslack.security;

import org.academiadecodigo.tailormoons.teamslack.persistence.dao.security.UserDao;
import org.academiadecodigo.tailormoons.teamslack.persistence.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

/**
 * Responsible for evaluating if a user has permission to access a page
 */
@Component
public class PermissionEvaluator {

    private UserDao userDao;

    /**
     * Sets the user data access object
     *
     * @param userDao the user DAO to set
     */
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    /**
     * Evaluates if the user has permission to access the page
     * @param authentication the authentication object
     * @param customerId the customer id
     * @return {@code true} if user has permission
     */
    public boolean hasPermission(Authentication authentication, int customerId) {

        // if spring-security has no authenticated user getPrincipal returns a returns with value "anonymousUser"
        if (authentication.getPrincipal() instanceof String) {
            return false;
        }

        User user = userDao.findByName(((UserDetails) authentication.getPrincipal()).getUsername());
        return user.getCustomer().getId() == customerId;
    }
}
