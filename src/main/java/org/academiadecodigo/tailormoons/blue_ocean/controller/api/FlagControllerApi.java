package org.academiadecodigo.tailormoons.blue_ocean.controller.api;

import org.academiadecodigo.tailormoons.blue_ocean.converter.flag.FlagReviewedDtoToFlagReviewed;
import org.academiadecodigo.tailormoons.blue_ocean.converter.flag.FlagReviewedToFlagReviewedDto;
import org.academiadecodigo.tailormoons.blue_ocean.converter.flag.FlagUnderReviewDtoToFlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.converter.flag.FlagUnderReviewToFlagUnderReviewDto;
import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagReviewedDto;
import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagUnderReviewDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagReviewedService;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagUnderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.LinkedList;
import java.util.List;

@Controller
public class FlagControllerApi {

    private FlagReviewedService flagReviewedService;

    private FlagUnderReviewService flagUnderReviewService;

    private FlagReviewedToFlagReviewedDto flagReviewedToFlagReviewedDto;

    private FlagReviewedDtoToFlagReviewed flagReviewedDtoToFlagReviewed;

    private FlagUnderReviewToFlagUnderReviewDto flagUnderReviewToFlagUnderReviewDto;

    private FlagUnderReviewDtoToFlagUnderReview flagUnderReviewDtoToFlagUnderReview;


    @Autowired
    public void setFlagReviewedService(FlagReviewedService flagReviewedService) {
        this.flagReviewedService = flagReviewedService;
    }


    @Autowired
    public void setFlagUnderReviewService(FlagUnderReviewService flagUnderReviewService) {
        this.flagUnderReviewService = flagUnderReviewService;
    }


    @Autowired
    public void setFlagReviewedToFlagReviewedDto(FlagReviewedToFlagReviewedDto flagReviewedToFlagReviewedDto) {
        this.flagReviewedToFlagReviewedDto = flagReviewedToFlagReviewedDto;
    }


    @Autowired
    public void setFlagReviewedDtoToFlagReviewed(FlagReviewedDtoToFlagReviewed flagReviewedDtoToFlagReviewed) {
        this.flagReviewedDtoToFlagReviewed = flagReviewedDtoToFlagReviewed;
    }


    @Autowired
    public void setFlagUnderReviewToFlagUnderReviewDto(FlagUnderReviewToFlagUnderReviewDto flagUnderReviewToFlagUnderReviewDto) {
        this.flagUnderReviewToFlagUnderReviewDto = flagUnderReviewToFlagUnderReviewDto;
    }


    @Autowired
    public void setFlagUnderReviewDtoToFlagUnderReview(FlagUnderReviewDtoToFlagUnderReview flagUnderReviewDtoToFlagUnderReview) {
        this.flagUnderReviewDtoToFlagUnderReview = flagUnderReviewDtoToFlagUnderReview;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/get-flag/list")
    public ResponseEntity<List<FlagUnderReviewDto>> getFlagList() {

        //List<FlagReviewed> flags = flagReviewedService.list();
        //List<FlagReviewedDto> flagDtos = flagReviewedToFlagReviewedDto.convert(flags);

        List<FlagUnderReview> flagsUnderReview = flagUnderReviewService.list();
        List<FlagUnderReviewDto> flagUnderReviewDtos = flagUnderReviewToFlagUnderReviewDto.convert(flagsUnderReview);

        return new ResponseEntity<>(flagUnderReviewDtos, HttpStatus.OK);
    }


}
