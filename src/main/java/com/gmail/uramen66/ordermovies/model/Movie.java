package com.gmail.uramen66.ordermovies.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    private String name;

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
    private Ganres status ;

    @Enumerated(EnumType.STRING)
    private TypeMovie typeMovie ;


    //@OneToMany
    //    @JoinTable(name = "movies_ganres)",
    //           joinColumns = {@JoinColumn(name = "car_id", referencedColumnName = "id")},
    //           inverseJoinColumns = {@JoinColumn(name = "part_details_id", referencedColumnName = "id")}
    //   )

}
