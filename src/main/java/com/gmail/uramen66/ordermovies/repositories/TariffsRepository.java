package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.model.Tariffs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TariffsRepository extends JpaRepository <Tariffs, Long> {
    @Query(value = "select t from Tariffs t where t.id = :id")
    Optional<Tariffs> findById(Long id);
}
