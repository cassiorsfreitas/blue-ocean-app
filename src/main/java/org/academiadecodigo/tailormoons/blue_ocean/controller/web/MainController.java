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


    @RequestMapping(method = RequestMethod.GET, path = "/lobby")
    public String getLobby(Model model) {
        model.addAttribute("customerId", 1);
        return "lobby";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/admin-panel")
    public String getAdminPanel(Model model) {
        model.addAttribute("customerId", 1);
        return "admin-panel";
    }
}