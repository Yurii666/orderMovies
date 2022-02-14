package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.requestedseats.RequestedSeatsDTO;
import com.gmail.uramen66.ordermovies.dto.requestedseats.RequestedSeatsMapper;
import com.gmail.uramen66.ordermovies.enums.StatusRequested;
import com.gmail.uramen66.ordermovies.exception.ResourceNotFoundException;
import com.gmail.uramen66.ordermovies.model.RequestedSeats;
import com.gmail.uramen66.ordermovies.repositories.RequestedSeatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RequestedSeatsService {

    private final RequestedSeatsRepository requestedSeatsRepository;
    private final RequestedSeatsMapper requestedSeatsMapper;

    public RequestedSeatsDTO createRequestedSeats(RequestedSeatsDTO requestedSeatsDTO){
        //I want to add automatic created oll RequestedSeats corresponding to the number of rowMax and seatMax
        // in the selected Hall.Maybe letter. And don't add create in Controller.
        RequestedSeats requestedSeats = RequestedSeats.builder()
                .row(requestedSeatsDTO.getRow())
                .seat(requestedSeatsDTO.getSeat())
                .statusRequested(StatusRequested.FREE)
                .build();

        RequestedSeats saveRequestedSeats = requestedSeatsRepository.saveAndFlush(requestedSeats);
        return requestedSeatsMapper.requestedSeatsToRequestedSeatsDTO(saveRequestedSeats);
    }
    public RequestedSeatsDTO findBiIdAndStatusRequested(Long id, StatusRequested statusRequested){
        return requestedSeatsRepository
                .findBiIdAndStatusRequested(id, statusRequested)
                .map(requestedSeatsMapper::requestedSeatsToRequestedSeatsDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public RequestedSeatsDTO findById(Long id){
        return requestedSeatsRepository.findById(id)
                .map(requestedSeatsMapper::requestedSeatsToRequestedSeatsDTO)
                .orElseThrow(ResourceNotFoundException::new);
    }

    public Page<RequestedSeatsDTO> findAllRequestedSeats(Pageable page){
        return requestedSeatsMapper.requestedSeatsToRequestedSeatsDTOs(requestedSeatsRepository.findAll(page));
    }

    public RequestedSeatsDTO updateReqestedSeats(Long id, RequestedSeatsDTO requestedSeatsDTO) {
        RequestedSeats requestedSeatsUpdateById = requestedSeatsRepository.findBiId(id)
                .orElseThrow(ResourceNotFoundException ::new);

        RequestedSeats actualRequestedSeats = requestedSeatsMapper.requestedSeatsDTOToRequestedSeats(requestedSeatsDTO);
        requestedSeatsUpdateById.setStatusRequested(actualRequestedSeats.getStatusRequested());

        return requestedSeatsMapper.requestedSeatsToRequestedSeatsDTO(requestedSeatsRepository.save(requestedSeatsUpdateById));
    }

//  I think all RequestedSeats in TimesLot mast automatic delete after some times, maybe a year after startTime.
//  But I add delete now.
    public void deleteRequestedSeats(Long id){
        requestedSeatsRepository.delete(requestedSeatsRepository.findBiId(id)
                .orElseThrow(ResourceNotFoundException::new));
        }

}
