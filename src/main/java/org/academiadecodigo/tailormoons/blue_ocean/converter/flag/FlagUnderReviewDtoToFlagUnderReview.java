package org.academiadecodigo.tailormoons.blue_ocean.converter.flag;

import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagUnderReviewDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagUnderReview;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagUnderReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FlagUnderReviewDtoToFlagUnderReview implements Converter<FlagUnderReviewDto, FlagUnderReview> {

    private FlagUnderReviewService flagUnderReviewService;


    @Autowired
    public void setFlagUnderReviewService(FlagUnderReviewService flagUnderReviewService) {
        this.flagUnderReviewService = flagUnderReviewService;
    }


    @Override
    public FlagUnderReview convert(FlagUnderReviewDto flagUnderReviewDto) {

        FlagUnderReview flagUnderReview = (flagUnderReviewDto.getId() != null ? flagUnderReviewService.get(flagUnderReviewDto.getId()) : new FlagUnderReview());

        flagUnderReview.setDescription(flagUnderReviewDto.getDescription());
        flagUnderReview.setLat(flagUnderReviewDto.getLat());
        flagUnderReview.setLng(flagUnderReviewDto.getLng());
        flagUnderReview.setState(flagUnderReviewDto.getState());

        return flagUnderReview;
    }

}
