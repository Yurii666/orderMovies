package com.gmail.uramen66.ordermovies.dto.requestedseats;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RequestedSeatsDTO {
    private Long id;
    public Integer row;
    public Integer seat;
}
