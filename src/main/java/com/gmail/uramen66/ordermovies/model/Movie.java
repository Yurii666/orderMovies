package com.gmail.uramen66.ordermovies.model;

import com.gmail.uramen66.ordermovies.enums.Ganres;
import com.gmail.uramen66.ordermovies.enums.TypeMovie;
import com.sun.istack.NotNull;
import lombok.*;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String movie_name;

    @NonNull
    private String description;

    //It's movie length in minutes
    @NonNull
    private Integer duration;

    @NotNull
    private Integer min_ege;

    @NonNull
    private float rating;

    @Enumerated(EnumType.STRING)
    private Ganres ganres;

    @Enumerated(EnumType.STRING)
    private TypeMovie typeMovie;
}
