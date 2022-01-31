package com.gmail.uramen66.ordermovies.dto.tariffs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TariffsDTO {
    private Long id;
    private String name;
    private int cost;
}
