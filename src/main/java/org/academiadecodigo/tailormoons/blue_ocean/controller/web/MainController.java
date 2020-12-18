package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String getIndex() {
        return "index";
    }


    @RequestMapping("/splash")
    public String getSplash() {
        return "splash";
    }


    @RequestMapping("/login")
    public String getLogin() {
        return "login";
    }


    @RequestMapping("/signup")
    public String getSignup() {
        return "signup";
    }


    @RequestMapping("/forgot-password")
    public String getForgotPassword() {
        return "forgot-password";
    }


    @RequestMapping("/lobby")
    public String getLobby() {

        return "lobby";
    }
}