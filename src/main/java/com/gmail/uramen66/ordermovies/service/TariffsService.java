package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.tariffs.TariffsDTO;
import com.gmail.uramen66.ordermovies.dto.tariffs.TariffsMapper;
import com.gmail.uramen66.ordermovies.exception.ResourceNotFoundException;
import com.gmail.uramen66.ordermovies.model.Tariffs;
import com.gmail.uramen66.ordermovies.repositories.TariffsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TariffsService {

    private final TariffsRepository tariffsRepository;
    private final TariffsMapper tariffsMapper;

    public TariffsDTO createTariffs(TariffsDTO tariffsDTO){
        Tariffs tariffs = Tariffs.builder()
                .name(tariffsDTO.getName())
                .cost(tariffsDTO.getCost())
                .build();

        Tariffs saveTariffs = tariffsRepository.saveAndFlush(tariffs);
        return tariffsMapper.tariffsToTariffsDto(saveTariffs);
    }

    public void deleteTariffs(Long id){
        tariffsRepository.delete(
                tariffsRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException ::new)
        );
    }

    public TariffsDTO updateTariffs(Long id, TariffsDTO tariffsDTO){
        Tariffs tariffsUpdateById = tariffsRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        Tariffs actualTariffs = tariffsMapper.tariffsDtoToTariffs(tariffsDTO);
        tariffsUpdateById.setName(actualTariffs.getName());
        tariffsUpdateById.setCost(actualTariffs.getCost());

        return tariffsMapper.tariffsToTariffsDto(tariffsRepository.save(tariffsUpdateById));
    }
    public Page<TariffsDTO> findAllTariffs(@PageableDefault Pageable pageable){
        return tariffsMapper.tariffsToTariffsDTOs(tariffsRepository.findAll(pageable));
    }

    public TariffsDTO findById(Long id){
        return tariffsRepository.findById(id)
                .map(tariffsMapper::tariffsToTariffsDto)
                .orElseThrow(ResourceNotFoundException::new);
    }
}
