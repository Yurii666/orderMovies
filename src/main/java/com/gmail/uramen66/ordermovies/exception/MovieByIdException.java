package com.gmail.uramen66.ordermovies.exception;

public class MovieByIdException extends RuntimeException{

    public static final String MOVIE_BY_ID_IS_NOT_FOUND = "Movie by id is not found";

    public MovieByIdException() {
        super(MOVIE_BY_ID_IS_NOT_FOUND);
    }

    public MovieByIdException(String message) {
        super(message);
    }

    public MovieByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
