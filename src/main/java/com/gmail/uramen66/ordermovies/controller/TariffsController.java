package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.dto.tariffs.TariffsDTO;
import com.gmail.uramen66.ordermovies.service.TariffsService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tariffs")
@AllArgsConstructor
public class TariffsController {
    public final TariffsService tariffsService;

    @GetMapping
    public Page<TariffsDTO> findAllTariffs(@PageableDefault Pageable pageable){
        return tariffsService.findAllTariffs(pageable);
    }
    @GetMapping("/{id}")
    public TariffsDTO findById(@PathVariable long id){
        return tariffsService.findById(id);
    }

    @PostMapping
    public TariffsDTO crateTariffs(TariffsDTO tariffsDTO){
        return tariffsService.createTariffs(tariffsDTO);
    }

    @PutMapping("/{id}")
    public TariffsDTO updateTariffs(@PathVariable long id, TariffsDTO tariffsDTO){
        return tariffsService.createTariffs(tariffsDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteTariffs(@PathVariable long id, TariffsDTO tariffsDTO){
        tariffsService.deleteTariffs(id);
    }
}
