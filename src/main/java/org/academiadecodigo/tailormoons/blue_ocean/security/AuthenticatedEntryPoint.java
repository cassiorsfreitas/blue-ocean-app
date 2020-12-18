package org.academiadecodigo.tailormoons.blue_ocean.security;

import org.academiadecodigo.tailormoons.blue_ocean.persistence.dao.security.UserDao;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.security.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

/**
 * Responsible for user authentication
 */
@Component
public class AuthenticatedEntryPoint extends SimpleUrlAuthenticationSuccessHandler {

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
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
     * Redirects the user on authentication success
     *
     * @param request        the http request
     * @param response       the http response
     * @param authentication the authentication object
     * @throws IOException
     */
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException {
        redirectStrategy.sendRedirect(request, response, getEntryPointUrl(authentication));
    }


    private String getEntryPointUrl(Authentication authentication) {
        List<String> roles = new LinkedList<>();
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority());
        }

        if (roles.contains("ROLE_ADMIN")) {
            return "/lobby";
        } else {
            User user = userDao.findByName(((UserDetails) authentication.getPrincipal()).getUsername());
            //return "/customer/" + user.getCustomer().getId();
            return "/lobby";
        }
    }

}
