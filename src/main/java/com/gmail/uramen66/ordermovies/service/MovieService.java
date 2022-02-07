package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.movie.MovieDTO;
import com.gmail.uramen66.ordermovies.dto.movie.MovieMapper;
import com.gmail.uramen66.ordermovies.model.Movie;
import com.gmail.uramen66.ordermovies.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private MovieRepository movieRepository;
    private MovieMapper movieMapper;

    public MovieDTO createMovie(MovieDTO movieDTO){
        Movie movie = Movie.builder()
                .movie_name(movieDTO.getMovie_name())
                .description(movieDTO.getDescription())
                .duration(movieDTO.getDuration())
                .min_ege(movieDTO.getMin_ege())
                .rating(movieDTO.getRating())
                .ganres(movieDTO.getGanres())
                .typeMovie(movieDTO.getTypeMovie())
                .build();

        Movie saveMovie = movieRepository.saveAndFlush(movie);
        return movieMapper.movieToMovieDto(saveMovie);
    }

    public MovieDTO findById(Long id) throws Exception{
        return movieRepository
                .findById(id)
                .map(movieMapper::movieToMovieDto)
                .orElseThrow(Exception::new);
    }

    public void deleteMovie(Long id) throws Exception {
        movieRepository.delete(movieRepository.findById(id)
                .orElseThrow(Exception::new)
        );
    }
    public Page<MovieDTO> findAllMovies(Pageable pageable) {
        return movieMapper.movieToMovieDTOs(movieRepository.findAll(pageable));
    }
}
