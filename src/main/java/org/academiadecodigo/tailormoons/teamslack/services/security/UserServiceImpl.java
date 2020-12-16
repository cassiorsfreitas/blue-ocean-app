package org.academiadecodigo.tailormoons.teamslack.services.security;

import org.academiadecodigo.tailormoons.teamslack.persistence.dao.security.UserDao;
import org.academiadecodigo.tailormoons.teamslack.persistence.model.security.Role;
import org.academiadecodigo.tailormoons.teamslack.persistence.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * An {@link UserService} implementation
 */
@Service
public class UserServiceImpl implements UserService {

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
     * Returns user details of a given username
     *
     * @param username the given username
     * @return the user details
     * @throws UsernameNotFoundException
     */
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userDao.findByName(username);
        Collection<Role> roles = user.getRoles();
        Collection<? extends GrantedAuthority> authorities = convert(roles);

        return new org.springframework.security.core.userdetails.User(user.getName(), user.getPassword(), authorities);
    }

    private Collection<? extends GrantedAuthority> convert(Collection<Role> roles) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : roles) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return authorities;
    }

}
