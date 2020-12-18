package org.academiadecodigo.tailormoons.blue_ocean.controller.api;

import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagDto;
import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagReviewedDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagReviewedService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagUnderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
public class FlagControllerApi {

    private FlagReviewedService flagReviewedService;

    private FlagUnderReviewService flagUnderReviewService;


    @Autowired
    public void setFlagReviewedService(FlagReviewedService flagReviewedService) {
        this.flagReviewedService = flagReviewedService;
    }


    @Autowired
    public void setFlagUnderReviewService(FlagUnderReviewService flagUnderReviewService) {
        this.flagUnderReviewService = flagUnderReviewService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/get-flag/list")
    public ResponseEntity<List<FlagReviewedDto>> getFlagList() {

        List<FlagReviewed> flags = flagReviewedService.list();
        List<FlagReviewedDto> flagDtos = new LinkedList<>();

        for (Flag flag : flags) {
            FlagReviewedDto flagDto = new FlagReviewedDto();
            flagDto.setLat(flag.getLat());
            flagDto.setLng(flag.getLng());
            flagDto.setCustomerId(flag.getCustomer().getId());

            flagDtos.add(flagDto);
        }

        return new ResponseEntity<>(flagDtos, HttpStatus.OK);
    }


}
