package com.gmail.uramen66.ordermovies.dto.timesLot;

import com.gmail.uramen66.ordermovies.model.TimesLot;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface TimesLotMapper {
    TimesLotDTO timesLotToTimesLotDto(TimesLot timesLot);

    TimesLot timesLotDtoToTimesLot(TimesLotDTO timesLotDTO);

    default Page<TimesLotDTO> timesLotToTimesLotDTOs(Page<TimesLot> timesLots){
        return timesLots.map(this::timesLotToTimesLotDto);
    }
}
