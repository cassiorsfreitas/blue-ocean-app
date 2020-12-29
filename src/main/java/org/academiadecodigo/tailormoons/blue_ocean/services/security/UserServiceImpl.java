package org.academiadecodigo.tailormoons.blue_ocean.services.security;

import org.academiadecodigo.tailormoons.blue_ocean.Configuration;
import org.academiadecodigo.tailormoons.blue_ocean.dto.RegisterCustomerDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.CustomerDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security.RoleDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security.UserDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.Role;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.RoleEnum;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

/**
 * An {@link UserService} implementation
 */
@Service
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    private CustomerDao customerDao;

    private RoleDao roleDao;


    /**
     * Sets the user data access object
     *
     * @param userDao the user DAO to set
     */
    @Autowired
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    @Autowired
    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }


    @Autowired
    public void setRoleDao(RoleDao roleDao) {
        this.roleDao = roleDao;
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


    @Override
    public boolean hasUser(String username) {
        return userDao.findByName(username) != null;
    }


    @Override
    public boolean hasUser(Integer id) {
        return userDao.findById(id) != null;
    }


    @Override
    public User get(Integer id) {
        return userDao.findById(id);
    }


    @Transactional
    @Override
    public User add(RegisterCustomerDto registerCustomerDto) {
        /*
        Create role
        Create user
        Create customer, ask user to add customer
         */

        Customer customer = new Customer();
        customer.setUsername(registerCustomerDto.getUsername());
        customer.setEmail(registerCustomerDto.getEmail());

        customer = customerDao.saveOrUpdate(customer);

        Role role = roleDao.findByName(RoleEnum.USER.getRole().getName());
        if (role == null) {
            role = roleDao.add(RoleEnum.USER.getRole());
        }

        Set<Role> roles = new HashSet<>();
        roles.add(role);

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String password = bCrypt.encode(registerCustomerDto.getPassword());

        User user = new User();
        user.setCustomer(customer);
        user.setPassword(password);
        user.setRoles(roles);
        user.setName(registerCustomerDto.getUsername());

        return userDao.saveOrUpdate(user);
    }


    @Transactional
    @Override
    public void delete(Integer id) {
        userDao.delete(id);
    }


    @Transactional
    @Override
    public void resetPassword(Integer id) {

        User user = userDao.findById(id);

        BCryptPasswordEncoder bCrypt = new BCryptPasswordEncoder();
        String password = bCrypt.encode(Configuration.DEFAULT_PASSWORD);

        user.setPassword(password);

        userDao.saveOrUpdate(user);
    }


    @Transactional
    @Override
    public void updateRole(Integer id, String role) {

        User user = userDao.findById(id);

        Set<Role> roles = new HashSet<>();
        switch (role) {
            case "admin":
                roles.add(RoleEnum.ADMIN.getRole());
            case "moderator":
                roles.add(RoleEnum.MODERATOR.getRole());
            case "user":
                roles.add(RoleEnum.USER.getRole());
        }

        user.setRoles(roles);

        userDao.saveOrUpdate(user);
    }

}
