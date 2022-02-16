package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.dto.hallPlaces.HallPlacesDTO;
import com.gmail.uramen66.ordermovies.service.HallPlacesService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hallplaces")
@AllArgsConstructor
public class HallPlacesController {
    public final HallPlacesService hallPlacesService;
    //Пока-что произошел затык с вопросом вывода посадочных мест по конкретному TimesLot
    //Потому как выводить все меcта  по всем залам -это бред, нам нужен конкретный TimesLot

    @GetMapping("/{id}")
    public HallPlacesDTO findById(@PathVariable long id){

        return hallPlacesService.findById(id);
    }

    @PutMapping("/{id}")
    public HallPlacesDTO updateHallPlaces(@PathVariable long id, HallPlacesDTO hallPlacesDTO){
        return hallPlacesService.updateHallPlaces(id,hallPlacesDTO);
    }
    //I don't add delete, I don't add creat - see RequestedSeatsService
}
