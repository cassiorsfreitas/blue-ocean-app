package org.academiadecodigo.tailormoons.blue_ocean.controller.api;

import org.academiadecodigo.tailormoons.blue_ocean.command.FlagDto;
import org.academiadecodigo.tailormoons.blue_ocean.persistence.model.flag.Flag;
import org.academiadecodigo.tailormoons.blue_ocean.services.FlagService;
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

    private FlagService flagService;


    @Autowired
    public void setFlagService(FlagService flagService) {
        this.flagService = flagService;
    }


    @RequestMapping(method = RequestMethod.GET, path = "/get-flag/list")
    public ResponseEntity<List<FlagDto>> getFlagList(Model model) {

        List<Flag> flags = flagService.list();
        List<FlagDto> flagDtos = new LinkedList<>();

        for (Flag flag : flags) {
            FlagDto flagDto = new FlagDto();
            flagDto.setLat(flag.getLat());
            flagDto.setLng(flag.getLng());
            flagDto.setCustomerId(flag.getCustomer().getId());

            flagDtos.add(flagDto);
        }

        return new ResponseEntity<>(flagDtos, HttpStatus.OK);
    }


}
