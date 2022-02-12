package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.enums.StatusRequested;
import com.gmail.uramen66.ordermovies.model.RequestedSeats;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RequestedSeatsRepository extends JpaRepository<RequestedSeats, Long> {

    @Query(value = "select rs from RequestedSeats rs where rs.id =:id and rs.statusRequested =:statusRequested")
    Optional<RequestedSeats> findBiIdAndStatusRequested(Long id, StatusRequested statusRequested);
}
