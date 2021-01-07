package org.academiadecodigo.tailormoons.blue_ocean.converter.flag;

import org.academiadecodigo.tailormoons.blue_ocean.converter.AbstractConverter;
import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagReviewedDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.FlagReviewed;
import org.springframework.stereotype.Component;

@Component
public class FlagReviewedToFlagReviewedDto extends AbstractConverter<FlagReviewed, FlagReviewedDto> {

    @Override
    public FlagReviewedDto convert(FlagReviewed flagReviewed) {

        FlagReviewedDto flagReviewedDto = new FlagReviewedDto();

        flagReviewedDto.setId(flagReviewed.getId());
        flagReviewedDto.setDescription(flagReviewed.getDescription());
        flagReviewedDto.setLat(flagReviewed.getLat());
        flagReviewedDto.setLng(flagReviewed.getLng());
        flagReviewedDto.setCustomerId(flagReviewed.getCustomer().getId());
        flagReviewedDto.setState(flagReviewed.getState());
        flagReviewedDto.setCreationTime(flagReviewed.getCreationTime().toString());

        return flagReviewedDto;
    }

}
