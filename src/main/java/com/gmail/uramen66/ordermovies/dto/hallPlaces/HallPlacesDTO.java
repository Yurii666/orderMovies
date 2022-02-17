package com.gmail.uramen66.ordermovies.dto.hallPlaces;

import com.gmail.uramen66.ordermovies.model.HallPlaces;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HallPlacesDTO extends HallPlaces {
    private Long id;
    public Integer row;
    public Integer seat;
}
