package com.gmail.uramen66.ordermovies.repositories;

import com.gmail.uramen66.ordermovies.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

 @Query(value = "select m from Movie m where m.id = :id")
 Optional<Movie> findBy(Long id);

//    @Query(value = "select m from Movie m where m.movie_name = :name")
//    Optional<Movie> findBy(String name);
}

