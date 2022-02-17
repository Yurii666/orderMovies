package com.gmail.uramen66.ordermovies.dto.hallPlaces;

import com.gmail.uramen66.ordermovies.model.HallPlaces;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface HallPlacesMapper {
    default HallPlacesDTO hallPlacesToHallPlacesDTO(HallPlaces hallPlaces){
        return HallPlacesDTO.builder()
                .id(hallPlaces.getId())
                .row(hallPlaces.getRow())
                .seat(hallPlaces.getSeat())
                .build();
    }

    default HallPlaces hallPlacesDTOToHallPlaces (HallPlacesDTO hallPlacesDTO){
        return HallPlaces.builder()
                .id(hallPlacesDTO.getId())
                .row(hallPlacesDTO.getRow())
                .seat(hallPlacesDTO.getSeat())
                .build();
    }
    default Page<HallPlacesDTO> hallPlacesToHallPlacesDTOs(Page<HallPlaces> hallPlaces){
        return hallPlaces.map(this::hallPlacesToHallPlacesDTO);
    }

}
