package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private CustomerService customerService;


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/")
    public String getIndex() {
        return "index";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/splash")
    public String getSplash() {
        return "splash";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/mylogin")
    public String getLogin() {
        return "mylogin";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/signup")
    public String getSignup() {
        return "signup";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/forgot-password")
    public String getForgotPassword() {
        return "forgot-password";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/lobby")
    public String getLobby(Model model) {
        model.addAttribute("customerId", 1);
        return "lobby";
    }

}