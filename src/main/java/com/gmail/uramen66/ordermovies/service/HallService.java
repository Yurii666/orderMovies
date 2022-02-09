package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.hall.HallDTO;
import com.gmail.uramen66.ordermovies.dto.hall.HallMapper;
import com.gmail.uramen66.ordermovies.model.Hall;
import com.gmail.uramen66.ordermovies.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private HallMapper hallMapper;

    public HallDTO createHall(HallDTO hallDTO){
        Hall hall = Hall.builder()
                .name(hallDTO.getName())
                .build();

        Hall saveHall = hallRepository.saveAndFlush(hall);
        return hallMapper.hallToHallDto(saveHall);
    }
    public HallDTO findHallById(Long id) throws Exception{
        return hallRepository
                .findById(id)
                .map(hallMapper::hallToHallDto)
                .orElseThrow(Exception::new);
    }
    private void deleteHall(long id) throws Exception{
        hallRepository.delete(
                hallRepository.findById(id)
                        .orElseThrow(Exception::new)
        );
    }
}
