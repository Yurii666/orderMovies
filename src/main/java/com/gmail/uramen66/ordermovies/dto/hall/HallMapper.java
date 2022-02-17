package com.gmail.uramen66.ordermovies.dto.hall;

import com.gmail.uramen66.ordermovies.model.Hall;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface HallMapper {
    HallDTO hallToHallDto(Hall hall);

    Hall hallDtoToHall(HallDTO hallDTO);

    default Page<HallDTO> hallToHallDTOs(Page<Hall> halls){
        return halls.map(this::hallToHallDto);
    }
}
