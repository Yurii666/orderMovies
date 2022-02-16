package com.gmail.uramen66.ordermovies.dto.timesLot;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TimesLotDTO {
    private Long id;
    public Date startTime;
}
