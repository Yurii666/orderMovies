package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.hallPlaces.HallPlacesDTO;
import com.gmail.uramen66.ordermovies.dto.hallPlaces.HallPlacesMapper;
import com.gmail.uramen66.ordermovies.enums.StatusRequested;
import com.gmail.uramen66.ordermovies.exception.PlaceById;
import com.gmail.uramen66.ordermovies.model.HallPlaces;
import com.gmail.uramen66.ordermovies.repositories.HallPlacesRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HallPlacesService {

    private final HallPlacesRepository hallPlacesRepository;
    private final HallPlacesMapper hallPlacesMapper;

    public HallPlaces createRequestedSeats(HallPlacesDTO hallPlacesDTO){
        //I want to add automatic created oll RequestedSeats corresponding to the number of rowMax and seatMax
        // in the selected Hall.Maybe letter. And don't add create in Controller.
        HallPlaces requestedSeats = HallPlaces.builder()
                .row(hallPlacesDTO.getRow())
                .seat(hallPlacesDTO.getSeat())
                .statusRequested(StatusRequested.FREE)
                .build();

        HallPlaces saveHallPlaces = hallPlacesRepository.saveAndFlush(requestedSeats);
        return hallPlacesMapper.hallPlacesToHallPlacesDTO(saveHallPlaces);
    }
    public HallPlaces findBiIdAndStatusRequested(Long id, StatusRequested statusRequested){
        return hallPlacesRepository
                .findBiIdAndStatusRequested(id, statusRequested)
                .map(hallPlacesMapper::hallPlacesToHallPlacesDTO)
                .orElseThrow(PlaceById::new);
    }

    public HallPlacesDTO findById(Long id){
        return hallPlacesRepository.findById(id)
                .map(hallPlacesMapper::hallPlacesToHallPlacesDTO)
                .orElseThrow(PlaceById::new);
    }

    public Page<HallPlacesDTO> findAllRequestedSeats(Pageable page){
        return hallPlacesMapper.hallPlacesToHallPlacesDTOs(hallPlacesRepository.findAll(page));
    }

    public HallPlacesDTO updateHallPlaces(Long id, HallPlacesDTO hallPlacesDTO) {
        HallPlaces hallPlacesUpdateById = hallPlacesRepository.findBiId(id)
                .orElseThrow(PlaceById ::new);

        HallPlaces actualHallPlaces = hallPlacesMapper.hallPlacesDTOToHallPlaces(hallPlacesDTO);
        hallPlacesUpdateById.setStatusRequested(actualHallPlaces.getStatusRequested());

        return hallPlacesMapper.hallPlacesToHallPlacesDTO(hallPlacesRepository.save(hallPlacesUpdateById));
    }

//  I think all RequestedSeats in TimesLot mast automatic delete after some times, maybe a year after startTime.
//  But I add delete now.
    public void deleteRequestedSeats(Long id){
        hallPlacesRepository.delete(hallPlacesRepository.findBiId(id)
                .orElseThrow(PlaceById::new));
        }

}
