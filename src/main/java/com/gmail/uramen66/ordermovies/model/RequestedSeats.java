package com.gmail.uramen66.ordermovies.model;

import com.gmail.uramen66.ordermovies.enums.StatusRequested;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "requestedseats")
public class RequestedSeats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    public Integer row;

    @NotNull
    public Integer seat;

    @Enumerated(EnumType.STRING)
    private StatusRequested statusRequested;


}
