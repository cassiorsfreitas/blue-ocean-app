package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.command.FlagDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

        System.out.println(flagDto);

        Flag flag = new FlagUnderReview();

        flag.setCoordX(flagDto.getLat());
        flag.setCoordY(flagDto.getLng());
        flag.setCustomer(customerService.get(flagDto.getCustomerId()));

        flagService.save(flag);

        return "lobby";
    }

}
