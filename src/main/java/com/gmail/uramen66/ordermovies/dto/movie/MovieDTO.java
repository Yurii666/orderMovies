package com.gmail.uramen66.ordermovies.dto.movie;

import com.gmail.uramen66.ordermovies.enums.Ganres;
import com.gmail.uramen66.ordermovies.enums.TypeMovie;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MovieDTO {
    private Long id;
    private String movie_name;
    private String description;
    private Integer duration;
    private Integer min_ege;
    private float rating;
    private Ganres ganres;
    private TypeMovie typeMovie;
}
