package com.gmail.uramen66.ordermovies.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "halls")
public class Hall {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NonNull
    private String name;

    @ManyToMany
    @JoinTable(name = "hall_timeslots)",
            joinColumns = {@JoinColumn(name = "hall_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "timeslot_id", referencedColumnName = "id")})
    private Set<Timeslot> timeslots;
}
