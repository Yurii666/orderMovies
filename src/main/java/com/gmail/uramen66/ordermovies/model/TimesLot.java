package com.gmail.uramen66.ordermovies.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.security.Timestamp;
import java.util.Set;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "timeslots")
public class TimesLot {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //It should beat the start time of the movie
    @Deprecated
    public Timestamp startTime;


    @ManyToMany
    @JoinTable(name = "timeslots_movies",
             joinColumns = {@JoinColumn(name = "timeslot_id", referencedColumnName = "id")},
             inverseJoinColumns = {@JoinColumn(name = "movie_id", referencedColumnName = "id")})
    private Set<Movie> movies;

    @ManyToMany
    @JoinTable(name = "timeslots_hall)",
            joinColumns = {@JoinColumn(name = "timeslot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "tariffs_id", referencedColumnName = "id")})
    private Set<Tariffs> tariffs;

    @ManyToMany
    @JoinTable(name = "timeslots_requestedseats)",
            joinColumns = {@JoinColumn(name = "timeslot_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "requestseats_id", referencedColumnName = "id")})
    private Set<RequestedSeats> requestedSeats;
}
