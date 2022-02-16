package com.gmail.uramen66.ordermovies.exception;

public class HallByIdException extends RuntimeException{

    public static final String HALL_BY_ID_IS_NOT_PRESENT = "Hall by id is not present";

    public HallByIdException() {
        super(HALL_BY_ID_IS_NOT_PRESENT);
    }

    public HallByIdException(String message) {
        super(message);
    }

    public HallByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
