package com.gmail.uramen66.ordermovies.exception;

public class TariffsByIdException extends RuntimeException{
    public TariffsByIdException() {
        super("Tariff By Id Is Not Found");
    }

    public TariffsByIdException(String message) {
        super(message);
    }

    public TariffsByIdException(String message, Throwable cause) {
        super(message, cause);
    }
}
