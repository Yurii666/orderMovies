package com.gmail.uramen66.ordermovies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum StatusType {
    ACTIVE("active"),
    NOT_ACTIVE("not_active"),
    DELETED("deleted");

    @Getter
    private String name;
}
