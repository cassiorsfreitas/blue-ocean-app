package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.command.FlagDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlagController {

    private FlagService flagService;

    private CustomerService customerService;


    @Autowired
    public void setFlagService(FlagService flagService) {
        this.flagService = flagService;
    }


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/add-flag")
    public String addFlag(Model model, @RequestBody FlagDto flagDto) {

        Flag flag = new FlagUnderReview();
        flag.setLat(flagDto.getLat());
        flag.setLng(flagDto.getLng());

        customerService.addFlagSubmitted(flagDto.getCustomerId(), flag);

        model.addAttribute("customerId", 1);

        return "lobby";
    }

}
