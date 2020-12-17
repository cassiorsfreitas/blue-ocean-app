package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    private CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


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
    public String getLobby(Model model) {
        model.addAttribute("customerId", 1);
        return "lobby";
    }

}