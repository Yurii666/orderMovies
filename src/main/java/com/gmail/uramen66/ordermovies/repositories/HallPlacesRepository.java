package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.enums.StatusRequested;
import com.gmail.uramen66.ordermovies.model.HallPlaces;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallPlacesRepository extends JpaRepository<HallPlaces, Long> {

    @Query(value = "select rs from HallPlaces rs where rs.id =:id and rs.statusRequested =:statusRequested")
    Optional<HallPlaces> findBiIdAndStatusRequested(Long id, StatusRequested statusRequested);

    @Query(value = "select rs from HallPlaces rs where rs.id =:id ")
    Optional<HallPlaces> findBiId(Long id);
}
