package com.gmail.uramen66.ordermovies.exception;

public class TimesLotById extends RuntimeException{

    public static final String TIMES_LOT_BY_ID_IS_NOT_FOUND = "TimesLot By Id Is Not Found";

    public TimesLotById() {
        super(TIMES_LOT_BY_ID_IS_NOT_FOUND);
    }

    public TimesLotById(String message) {
        super(message);
    }

    public TimesLotById(String message, Throwable cause) {
        super(message, cause);
    }
}
