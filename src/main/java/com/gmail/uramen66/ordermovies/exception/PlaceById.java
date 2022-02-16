package com.gmail.uramen66.ordermovies.exception;

public class PlaceById extends RuntimeException{

    public static final String PLACE_BY_ID_IS_NOT_FOUND = "Place By Id Is Not Found";

    public PlaceById() {
        super(PLACE_BY_ID_IS_NOT_FOUND);
    }

    public PlaceById(String message) {
        super(message);
    }

    public PlaceById(String message, Throwable cause) {
        super(message, cause);
    }
}
