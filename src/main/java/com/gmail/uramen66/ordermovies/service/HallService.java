package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.hall.HallDTO;
import com.gmail.uramen66.ordermovies.dto.hall.HallMapper;
import com.gmail.uramen66.ordermovies.exception.ResourceNotFoundException;
import com.gmail.uramen66.ordermovies.model.Hall;
import com.gmail.uramen66.ordermovies.repositories.HallRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class HallService {

    private final HallRepository hallRepository;
    private final HallMapper hallMapper;

    public HallDTO createHall(HallDTO hallDTO){
        Hall hall = Hall.builder()
                .name(hallDTO.getName())
                .build();

        Hall saveHall = hallRepository.saveAndFlush(hall);
        return hallMapper.hallToHallDto(saveHall);
    }


    public HallDTO findHallById(Long id) {
        return hallRepository
                .findById(id)
                .map(hallMapper::hallToHallDto)
                .orElseThrow(ResourceNotFoundException ::new);
    }
    public void deleteHall(long id){
        hallRepository.delete(
                hallRepository.findById(id)
                        .orElseThrow(ResourceNotFoundException ::new)
        );
    }

    public Page<HallDTO> findAllHalls(Pageable pageable){
        return hallMapper.hallToHallDTOs(hallRepository.findAll(pageable));
    }
    public HallDTO updateHall(Long id, HallDTO hallDTO){
        Hall hallUpdateById = hallRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);

        Hall actualHall = hallMapper.hallDtoToHall(hallDTO);
        hallUpdateById.setName(actualHall.getName());

        return hallMapper.hallToHallDto(hallRepository.save(hallUpdateById));
    }

}
