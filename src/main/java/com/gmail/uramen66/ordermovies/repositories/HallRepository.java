package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.model.Hall;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface HallRepository extends JpaRepository<Hall, Long> {
    @Query(value = "select h from Hall h where h.id = :id")
    Optional<Hall> findById(Long id);
}
