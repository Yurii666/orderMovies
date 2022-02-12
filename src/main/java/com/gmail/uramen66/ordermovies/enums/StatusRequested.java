package com.gmail.uramen66.ordermovies.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusRequested {
    FREE("free"),
    BUSY("busy"),
    BOOKED("booked");

    @Getter
    private String statusrequest;
}
