package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.converter.CustomerToCustomerDto;
import org.academiadecodigo.tailormoons.blue_ocean.converter.flag.FlagReviewedToFlagReviewedDto;
import org.academiadecodigo.tailormoons.blue_ocean.converter.flag.FlagSubmittedToFlagSubmittedDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.Customer;
import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private CustomerService customerService;

    private CustomerToCustomerDto customerToCustomerDto;
    private FlagSubmittedToFlagSubmittedDto flagSubmittedToFlagSubmittedDto;
    private FlagReviewedToFlagReviewedDto flagReviewedToFlagReviewedDto;

    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    @Autowired
    public void setCustomerToCustomerDto(CustomerToCustomerDto customerToCustomerDto) {
        this.customerToCustomerDto = customerToCustomerDto;
    }

    @Autowired
    public void setFlagSubmittedToFlagSubmittedDto(FlagSubmittedToFlagSubmittedDto flagSubmittedToFlagSubmittedDto) {
        this.flagSubmittedToFlagSubmittedDto = flagSubmittedToFlagSubmittedDto;
    }

    @Autowired
    public void setFlagReviewedToFlagReviewedDto(FlagReviewedToFlagReviewedDto flagReviewedToFlagReviewedDto) {
        this.flagReviewedToFlagReviewedDto = flagReviewedToFlagReviewedDto;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/lobby")
    public String getLobby(Model model) {
        model.addAttribute("customerId", 1);
        return "lobby";
    }

    @RequestMapping(method = RequestMethod.GET, path = "/user-profile/{id}")
    public String getUserProfile(@PathVariable Integer id, Model model) {

        Customer customer = customerService.get(id);

        model.addAttribute("customer", customerToCustomerDto.convert(customer));
        model.addAttribute("flagsSubmitted", flagSubmittedToFlagSubmittedDto.convert(customer.getFlagsSubmitted()));
        model.addAttribute("flagsReviewed", flagReviewedToFlagReviewedDto.convert(customer.getFlagsReviewed()));

        return "user-profile";
    }

    // WIP
    @RequestMapping(method = RequestMethod.GET, path = "/user-profile/setting-profile")
    public String getUserProfileSettings(){

        return "setting-profile";
    }

}