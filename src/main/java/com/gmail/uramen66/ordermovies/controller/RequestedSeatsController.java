package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.dto.requestedseats.RequestedSeatsDTO;
import com.gmail.uramen66.ordermovies.service.RequestedSeatsService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/requestedseats")
@AllArgsConstructor
public class RequestedSeatsController {
    public final RequestedSeatsService requestedSeatsService;
    //Пока-что произошел затык с вопросом вывода посадочных мест по конкретному TimesLot
    //Потому как выводить все меcта  по всем залам -это бред, нам нужен конкретный TimesLot


    @GetMapping("/{id}")
    public RequestedSeatsDTO findById(@PathVariable long id){
        return requestedSeatsService.findById(id);
    }

    @PutMapping("/{id}")
    public RequestedSeatsDTO updateRequestedSeats(@PathVariable long id, RequestedSeatsDTO requestedSeatsDTO){
        return requestedSeatsService.updateReqestedSeats(id,requestedSeatsDTO);
    }
    //I don't add delete, I don't add creat - see RequestedSeatsService
}
