package com.gmail.uramen66.ordermovies.service;

import com.gmail.uramen66.ordermovies.dto.movie.MovieDTO;
import com.gmail.uramen66.ordermovies.dto.movie.MovieMapper;
import com.gmail.uramen66.ordermovies.exception.MovieByIdException;
import com.gmail.uramen66.ordermovies.model.Movie;
import com.gmail.uramen66.ordermovies.repositories.MovieRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MovieService {

    private final MovieRepository movieRepository;
    private final MovieMapper movieMapper;

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

    public MovieDTO findById(Long id) {
        return movieRepository
                .findById(id)
                .map(movieMapper::movieToMovieDto)
                .orElseThrow(MovieByIdException::new);
    }

    public void deleteMovie(Long id)  {
        movieRepository.delete(movieRepository.findById(id)
                .orElseThrow(MovieByIdException::new)
        );
    }
    public Page<MovieDTO> findAllMovies(Pageable pageable) {
        return movieMapper.movieToMovieDTOs(movieRepository.findAll(pageable));
    }
    public MovieDTO updateMovie(Long id, MovieDTO movieDTO){
        Movie movieUpdateById = movieRepository.findById(id)
                .orElseThrow(MovieByIdException::new);

        Movie actualMovie = movieMapper.movieDtoToMovie(movieDTO);
        movieUpdateById.setMovie_name(actualMovie.getMovie_name());
        movieUpdateById.setDescription(actualMovie.getDescription());
        movieUpdateById.setDuration(actualMovie.getDuration());
        movieUpdateById.setMin_ege(actualMovie.getMin_ege());
        movieUpdateById.setRating(actualMovie.getRating());
        movieUpdateById.setGanres(actualMovie.getGanres());
        movieUpdateById.setTypeMovie(actualMovie.getTypeMovie());

        return movieMapper.movieToMovieDto(movieRepository.save(movieUpdateById));
    }
}
