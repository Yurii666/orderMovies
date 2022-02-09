package com.gmail.uramen66.ordermovies.dto.timesLot;

import com.gmail.uramen66.ordermovies.model.TimesLot;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface TimesLotMapper {
    TimesLotDTO timesLotToTamesLotDto(TimesLot timesLot);

    TimesLot timesLotDtoToTimesLot(TimesLotDTO timesLotDTO);
}
