package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.model.TimesLot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TimesLotRepository extends JpaRepository<TimesLot, Long> {
    @Query(value = "select tl from TimesLot tl where tl.id = :id")
    Optional<TimesLot> findById(Long Id);
}
