package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.requestedseats.RequestedSeatsDTO;
import com.gmail.uramen66.ordermovies.dto.requestedseats.RequestedSeatsMapper;
import com.gmail.uramen66.ordermovies.enums.StatusRequested;
import com.gmail.uramen66.ordermovies.model.RequestedSeats;
import com.gmail.uramen66.ordermovies.repositories.RequestedSeatsRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import static com.gmail.uramen66.ordermovies.enums.StatusRequested.*;

@Service
@AllArgsConstructor
public class RequestedSeatsService {

    private RequestedSeatsRepository requestedSeatsRepository;
    private RequestedSeatsMapper requestedSeatsMapper;

    public RequestedSeatsDTO createRequestedSeats(RequestedSeatsDTO requestedSeatsDTO){
        RequestedSeats requestedSeats = RequestedSeats.builder()
                .row(requestedSeatsDTO.getRow())
                .seat(requestedSeatsDTO.getSeat())
                .statusRequested(StatusRequested.FREE)
                .build();

        RequestedSeats saveRequestedSeats = requestedSeatsRepository.saveAndFlush(requestedSeats);
        return requestedSeatsMapper.requestedSeatsToRequestedSeatsDTO(saveRequestedSeats);
    }
    public RequestedSeatsDTO findBiIdAndStatusRequested(Long id) throws  Exception{
        return requestedSeatsRepository
                .findBiIdAndStatusRequested(id, StatusRequested.FREE)
                .map(requestedSeatsMapper::requestedSeatsToRequestedSeatsDTO)
                .orElseThrow(Exception::new);
    }

    public void buySeats(Long id) throws Exception {
        RequestedSeats requestedSeats = requestedSeatsRepository
                .findBiIdAndStatusRequested(id, StatusRequested.FREE)
                .orElseThrow(Exception::new);
        requestedSeats.setStatusRequested(BUSY);
    }
    public void reservedSeats(Long id) throws Exception{
        RequestedSeats requestedSeats =requestedSeatsRepository
                .findBiIdAndStatusRequested(id, StatusRequested.FREE)
                .orElseThrow(Exception::new);
        requestedSeats.setStatusRequested(BOOKED);
    }

    public void bookingConfirmation (Long id) throws Exception{
        RequestedSeats requestedSeats =requestedSeatsRepository
                .findBiIdAndStatusRequested(id, BOOKED)
                .orElseThrow(Exception::new);
        requestedSeats.setStatusRequested(BUSY);
    }

    public void returnBoo(Long id) throws Exception{
        RequestedSeats requestedSeats =requestedSeatsRepository
                .findBiIdAndStatusRequested(id, BOOKED)
                .orElseThrow(Exception::new);
        requestedSeats.setStatusRequested(FREE);
    }
    public Page<RequestedSeatsDTO> findAllRequestedSeats(Pageable pageable){
        return requestedSeatsMapper.requestedSeatsToRequestedSeatsDTOs(requestedSeatsRepository.findAll(pageable));
    }
}
