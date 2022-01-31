package com.gmail.uramen66.ordermovies.dto.movie;

import com.gmail.uramen66.ordermovies.model.Movie;

public interface MovieMapper {
    MovieDTO movieToMovieDto(Movie movie);

    Movie movieDtoToMovie(MovieDTO movieDTO);
}
