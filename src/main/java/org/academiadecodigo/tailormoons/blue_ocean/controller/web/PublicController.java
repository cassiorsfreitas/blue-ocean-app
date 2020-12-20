package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PublicController {

    @RequestMapping(method = RequestMethod.GET, path = {"", "index", "index.html"})
    public String index() {
        return getView("index");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"splash", "splash.html"})
    public String splash() {
        return getView("splash");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"login", "login.html"})
    public String login() {
        return getView("login");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"signup", "signup.html"})
    public String signup() {
        return getView("signup");
    }


    @RequestMapping(method = RequestMethod.GET, path = {"forgot-password", "forgot-password.html"})
    public String forgotPassword() {
        return getView("forgot-password");
    }


    private String getView(String viewDefault) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        /*if (authentication.isAuthenticated()) {
            return "redirect:/lobby";
        }*/
        return viewDefault;
    }

}
