package com.gmail.uramen66.ordermovies.dto.requestedseats;

import com.gmail.uramen66.ordermovies.model.RequestedSeats;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Service;

@Service
@Mapper
public interface RequestedSeatsMapper {
    RequestedSeatsDTO requestedSeatsToRequestedSeatsDTO(RequestedSeats requestedSeats);

    RequestedSeats requestedSeatsDTOToRequestedSeats (RequestedSeatsDTO requestedSeatsDTO);

}
