package com.gmail.uramen66.ordermovies.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum RoleType {
    ADMIN("admin"),
    USER("user"),
    CASHIER("cashier");

    @Getter
    private String name;
}
