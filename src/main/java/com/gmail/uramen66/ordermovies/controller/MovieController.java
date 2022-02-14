package com.gmail.uramen66.ordermovies.controller;

import com.gmail.uramen66.ordermovies.dto.movie.MovieDTO;
import com.gmail.uramen66.ordermovies.service.MovieService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
@AllArgsConstructor
public class MovieController {

    public final MovieService movieService;

    @GetMapping
    public Page<MovieDTO> findAllMovie(@PageableDefault(sort = {"id"}, direction = Sort.Direction.ASC, size = 25 )Pageable page){
        return movieService.findAllMovies(page);
    }
    @GetMapping("/{id}")
    public MovieDTO findById(@PathVariable long id){
        return movieService.findById(id);
    }

    @PostMapping
    public MovieDTO createMovie(MovieDTO movieDTO){
        return  movieService.createMovie(movieDTO);
    }

    @PutMapping("/{id}")
    public MovieDTO updateMovie(@PathVariable long id, MovieDTO movieDTO){
        return movieService.updateMovie(id, movieDTO);
    }
    @DeleteMapping("/{id}")
    public void deleteMovie(@PathVariable long id, MovieDTO movieDTO){
        movieService.deleteMovie(id);
    }
}
