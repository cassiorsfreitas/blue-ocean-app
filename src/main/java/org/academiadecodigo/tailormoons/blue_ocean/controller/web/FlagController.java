package org.academiadecodigo.tailormoons.blue_ocean.controller.web;

import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagUnderReviewDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.services.CustomerService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagReviewedService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagUnderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FlagController {

    private FlagReviewedService flagReviewedService;

    private FlagUnderReviewService flagUnderReviewService;

    private CustomerService customerService;


    @Autowired
    public void setFlagReviewedService(FlagReviewedService flagReviewedService) {
        this.flagReviewedService = flagReviewedService;
    }


    @Autowired
    public void setFlagUnderReviewService(FlagUnderReviewService flagUnderReviewService) {
        this.flagUnderReviewService = flagUnderReviewService;
    }


    @Autowired
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }


    @RequestMapping(method = RequestMethod.POST, path = "/add-flag")
    public String addFlag(Model model, @RequestBody FlagUnderReviewDto flagDto) {

        FlagUnderReview flag = new FlagUnderReview();
        flag.setLat(flagDto.getLat());
        flag.setLng(flagDto.getLng());

        customerService.addFlagSubmitted(flagDto.getCustomerId(), flag);

        model.addAttribute("customerId", 1);

        return "lobby";
    }


    @RequestMapping(method = RequestMethod.GET, path = "/user/{id}")
    public String getUserById(Model model, @PathVariable(value = "id") Integer id) {

        //List<FlagReviewed> flagReviewedList = customerService.get(id).getFlagsSubmitted();

        model.addAttribute("flagDtoReviewed", flagReviewedService.list());
        model.addAttribute("flagDtoUnderReview", flagUnderReviewService.list());

        return "profile";
    }

}
