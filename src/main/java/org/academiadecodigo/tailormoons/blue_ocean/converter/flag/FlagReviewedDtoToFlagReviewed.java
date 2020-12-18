package org.academiadecodigo.tailormoons.blue_ocean.converter.flag;

import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagReviewedDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagReviewedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FlagReviewedDtoToFlagReviewed implements Converter<FlagReviewedDto, FlagReviewed> {

    private FlagReviewedService flagReviewedService;


    @Autowired
    public void setFlagReviewedService(FlagReviewedService flagReviewedService) {
        this.flagReviewedService = flagReviewedService;
    }


    @Override
    public FlagReviewed convert(FlagReviewedDto flagReviewedDto) {

        FlagReviewed flagReviewed = (flagReviewedDto.getId() != null ? flagReviewedService.get(flagReviewedDto.getId()) : new FlagReviewed());

        flagReviewed.setLat(flagReviewed.getLat());
        flagReviewed.setLng(flagReviewed.getLng());
        flagReviewed.setDescription(flagReviewedDto.getDescription());
        flagReviewed.setState(flagReviewedDto.getState());

        return flagReviewed;
    }

}
