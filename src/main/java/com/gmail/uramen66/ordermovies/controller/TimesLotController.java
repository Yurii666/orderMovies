package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.dto.timesLot.TimesLotDTO;
import com.gmail.uramen66.ordermovies.service.TimesLotService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping
@AllArgsConstructor
public class TimesLotController {
    public final TimesLotService timesLotService;

    @GetMapping
    public Page<TimesLotDTO> findAllTimesLot(@PageableDefault(sort = {"id"},direction = Sort.Direction.ASC, size = 20)Pageable page){
        return timesLotService.findAllTimesLot(page);
    }

    @GetMapping("/{id}")
    public TimesLotDTO findById(@PathVariable long id, Pageable page){
        return timesLotService.findById(id);
    }

    @PostMapping
    public TimesLotDTO createTimesLot(TimesLotDTO timesLotDTO){
        return timesLotService.createTimesLot(timesLotDTO);
    }

    @PutMapping("/id")
    public TimesLotDTO updateTimesLot(@PathVariable long id, TimesLotDTO timesLotDTO){
        return timesLotService.updateTimesLot(id, timesLotDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteTimesLot(@PathVariable long id, TimesLotDTO timesLotDTO){
        timesLotService.deleteTimesLot(id);
    }
}
