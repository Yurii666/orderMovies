package com.gmail.uramen66.ordermovies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor

public enum Ganres {
    ACTION("Action"),
    DRAMA("Drama"),
    COMEDY("Comedy"),
    KIDS("Kids"),
    HORROR("Horror"),
    ROMANCE("romance"),
    SCI_FI("SCI-FI"),
    ANIMATED("Animated"),
    DOCUMENTARIES("Documentares"),
    IMAX("IMax"),
    SUSPENSE("Suspense"),
    INDIE("Indie"),
    FOREIGN("Foreign"),
    SPECIAL_EVENTS("Special events"),
    WESTERN("Western"),
    SPY_FILM("SPY Film"),
    HISTORICAL_FILM("Histori Film"),
    CLASSIC("Classic"),
    WAR("War"),
    DANCE("Dance");

    @Getter
    private String name;
}
