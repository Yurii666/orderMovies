package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.tariffs.TariffsDTO;
import com.gmail.uramen66.ordermovies.dto.tariffs.TariffsMapper;
import com.gmail.uramen66.ordermovies.model.Tariffs;
import com.gmail.uramen66.ordermovies.repositories.TariffsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TariffsService {

    private TariffsRepository tariffsRepository;
    private TariffsMapper tariffsMapper;

    public TariffsDTO createTariffs(TariffsDTO tariffsDTO){
        Tariffs tariffs = Tariffs.builder()
                .name(tariffsDTO.getName())
                .cost(tariffsDTO.getCost())
                .build();

        Tariffs saveTariffs = tariffsRepository.saveAndFlush(tariffs);
        return tariffsMapper.tariffsToTariffsDto(saveTariffs);
    }
    private void deleteTariffs(Long id)throws Exception{
        tariffsRepository.delete(
                tariffsRepository.findById(id)
                        .orElseThrow(Exception::new)
        );
    }

}
