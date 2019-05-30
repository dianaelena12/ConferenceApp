package com.fmgs.conferenceapp.model;

import java.util.HashMap;
import java.util.Map;

public enum Qualifiers {
    STRONG_ACCEPT(1),
    ACCEPT(2),
    WEAK_ACCEPT(3),
    STRONG_REJECT(4),
    REJECT(5),
    WEAK_REJECT(6);


    private static Map map = new HashMap<>();

    static {
        for (Qualifiers qualifiers : Qualifiers.values()) {
            map.put(qualifiers.value, qualifiers);
        }
    }

    private int value;

    Qualifiers(int value) {
        this.value = value;
    }

    public static Qualifiers valueOf(int qualifier) {
        return (Qualifiers) map.get(qualifier);
    }

    public int getValue() {
        return value;
    }

}
