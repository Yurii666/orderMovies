package com.gmail.uramen66.ordermovies.dto.hall;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class HallDTO {
    private Long id;
    private String name;
}
