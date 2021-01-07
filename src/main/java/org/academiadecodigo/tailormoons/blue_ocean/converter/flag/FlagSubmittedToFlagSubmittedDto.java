package org.academiadecodigo.tailormoons.blue_ocean.converter.flag;

import org.academiadecodigo.tailormoons.blue_ocean.converter.AbstractConverter;
import org.academiadecodigo.tailormoons.blue_ocean.dto.flag.FlagSubmittedDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.springframework.stereotype.Component;

@Component
public class FlagSubmittedToFlagSubmittedDto extends AbstractConverter<Flag, FlagSubmittedDto> {

    @Override
    public FlagSubmittedDto convert(Flag flag) {

        FlagSubmittedDto flagSubmittedDto = new FlagSubmittedDto();

        flagSubmittedDto.setId(flag.getId());
        flagSubmittedDto.setDescription(flag.getDescription());
        flagSubmittedDto.setLat(flag.getLat());
        flagSubmittedDto.setLng(flag.getLng());
        flagSubmittedDto.setCustomerId(flag.getCustomer().getId());

        String date = flag.getCreationTime().toString();
        date = date.substring(0,16) + "h";

        flagSubmittedDto.setCreationTime(date);

        return flagSubmittedDto;
    }
}
