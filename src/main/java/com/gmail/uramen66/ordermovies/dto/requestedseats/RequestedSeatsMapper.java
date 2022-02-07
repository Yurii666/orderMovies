package com.gmail.uramen66.ordermovies.dto.requestedseats;

import com.gmail.uramen66.ordermovies.model.RequestedSeats;
import org.mapstruct.Mapper;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface RequestedSeatsMapper {
    default RequestedSeatsDTO requestedSeatsToRequestedSeatsDTO(RequestedSeats requestedSeats){
        return RequestedSeatsDTO.builder()
                .id(requestedSeats.getId())
                .row(requestedSeats.getRow())
                .seat(requestedSeats.getSeat())
                .build();
    }

    default RequestedSeats requestedSeatsDTOToRequestedSeats (RequestedSeatsDTO requestedSeatsDTO){
        return RequestedSeats.builder()
                .id(requestedSeatsDTO.getId())
                .row(requestedSeatsDTO.getRow())
                .seat(requestedSeatsDTO.getSeat())
                .build();
    }
    default Page<RequestedSeatsDTO> requestedSeatsToRequestedSeatsDTOs(Page<RequestedSeats> requestedSeats){
        return requestedSeats.map(this::requestedSeatsToRequestedSeatsDTO);
    }

}
