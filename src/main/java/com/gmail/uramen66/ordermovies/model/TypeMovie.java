package com.gmail.uramen66.ordermovies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum TypeMovie {
    D2("2D"),
    D3("3D");

    @Getter
    public String name;
}
