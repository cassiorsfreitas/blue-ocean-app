package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.command.FlagDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

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


    @RequestMapping("/add-flag")
    public String addFlag(@RequestBody FlagDto flagDto) {

        Customer customer = customerService.get(flagDto.getId());

        Flag flag = new FlagUnderReview();

        flag.setId(flagDto.getId());
        flag.setCoordX(flagDto.getCoordX());
        flag.setCoordY(flagDto.getCoordY());
        flag.setCustomer(customer);

        flagService.save(flag);

        return "lobby";
    }

}
