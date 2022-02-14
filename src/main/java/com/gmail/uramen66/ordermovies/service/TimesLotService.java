package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.timesLot.TimesLotDTO;
import com.gmail.uramen66.ordermovies.dto.timesLot.TimesLotMapper;
import com.gmail.uramen66.ordermovies.exception.ResourceNotFoundException;
import com.gmail.uramen66.ordermovies.model.TimesLot;
import com.gmail.uramen66.ordermovies.repositories.TimesLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TimesLotService {
    private final TimesLotRepository timesLotRepository;
    private final TimesLotMapper timesLotMapper;

    public TimesLotDTO createTimesLot (TimesLotDTO timesLotDTO){
        TimesLot timesLot = TimesLot.builder()
//                .startTime(timesLotDTO.getStartTime())
                .build();

        TimesLot saveTimesLot = timesLotRepository.saveAndFlush(timesLot);
        return timesLotMapper.timesLotToTimesLotDto(saveTimesLot);
    }

    public TimesLotDTO findById(Long id) {
        return timesLotRepository
                .findById(id)
                .map(timesLotMapper::timesLotToTimesLotDto)
                .orElseThrow(ResourceNotFoundException ::new);
    }
    public void deleteTimesLot(Long id) {
        timesLotRepository.delete(
                timesLotRepository.findById(id)
                .orElseThrow(ResourceNotFoundException ::new)
        );
    }
    public TimesLotDTO updateTimesLot(Long id, TimesLotDTO timesLotDTO){
        TimesLot timesLotUpdateById = timesLotRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        TimesLot actualTimesLot = timesLotMapper.timesLotDtoToTimesLot(timesLotDTO);
        timesLotUpdateById.setStartTime(actualTimesLot.getStartTime());

        return timesLotMapper.timesLotToTimesLotDto(timesLotRepository.save(timesLotUpdateById));
    }

    public Page<TimesLotDTO> findAllTimesLot(Pageable page){
        return timesLotMapper.timesLotToTimesLotDTOs(timesLotRepository.findAll(page));
    }
}
