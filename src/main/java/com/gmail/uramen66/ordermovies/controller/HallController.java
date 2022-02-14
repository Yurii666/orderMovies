package com.gmail.uramen66.ordermovies.controller;


import com.gmail.uramen66.ordermovies.dto.hall.HallDTO;
import com.gmail.uramen66.ordermovies.service.HallService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/halls")
@AllArgsConstructor
public class HallController {
    public final HallService hallService;

    @GetMapping
    public Page<HallDTO> findAllHalls(@PageableDefault(sort={"id"}, direction = Sort.Direction.ASC)Pageable page){
        return hallService.findAllHalls(page);
    }
    @GetMapping("/{id}")
    public HallDTO findById(@PathVariable long id){
        return hallService.findHallById(id);
    }
    @PostMapping
    public HallDTO createHall(HallDTO hallDTO){
        return hallService.createHall(hallDTO);
    }
    @PutMapping("/{id}")
    public HallDTO updateHall(@PathVariable long id, HallDTO hallDTO){
        return hallService.updateHall(id, hallDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteHall(@PathVariable long id, HallDTO hallDTO){
        hallService.deleteHall(id);
    }

}
