package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.timesLot.TimesLotDTO;
import com.gmail.uramen66.ordermovies.dto.timesLot.TimesLotMapper;
import com.gmail.uramen66.ordermovies.model.TimesLot;
import com.gmail.uramen66.ordermovies.repositories.TimesLotRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TimesLotService {
    private TimesLotRepository timesLotRepository;
    private TimesLotMapper timesLotMapper;

    public TimesLotDTO createTimesLot (TimesLotDTO timesLotDTO){
        TimesLot timesLot = TimesLot.builder()
//                .startTime(timesLotDTO.getStartTime())
                .build();

        TimesLot saveTimesLot = timesLotRepository.saveAndFlush(timesLot);
        return timesLotMapper.timesLotToTamesLotDto(saveTimesLot);
    }

    public TimesLotDTO findById(Long id) throws Exception{
        return timesLotRepository
                .findById(id)
                .map(timesLotMapper::timesLotToTamesLotDto)
                .orElseThrow(Exception::new);
    }
    public void deleteTimesLot(Long id) throws Exception{
        timesLotRepository.delete(
                timesLotRepository.findById(id)
                .orElseThrow(Exception::new)
        );
    }

}
