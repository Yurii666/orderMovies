package com.gmail.uramen66.ordermovies.dto.movie;

import com.gmail.uramen66.ordermovies.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface MovieMapper {
    default MovieDTO movieToMovieDto(Movie movie){
        return MovieDTO.builder()
                .id(movie.getId())
                .movie_name(movie.getMovie_name())
                .description(movie.getDescription())
                .duration(movie.getDuration())
                .min_ege(movie.getMin_ege())
                .rating(movie.getRating())
                .build();
    }

    default Movie movieDtoToMovie(MovieDTO movieDTO){
        return Movie.builder()
                .id(movieDTO.getId())
                .movie_name(movieDTO.getMovie_name())
                .description(movieDTO.getDescription())
                .duration(movieDTO.getDuration())
                .min_ege(movieDTO.getMin_ege())
                .rating(movieDTO.getRating())
                .build();
    }
    default Page<MovieDTO> movieToMovieDTOs(Page<Movie> movies){
        return movies.map(this::movieToMovieDto);
    }
}
