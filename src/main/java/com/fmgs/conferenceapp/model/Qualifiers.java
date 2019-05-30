package com.fmgs.conferenceapp.model;

import java.util.HashMap;
import java.util.Map;

public enum Qualifiers {
    STRONG_ACCEPT(6),
    ACCEPT(5),
    WEAK_ACCEPT(4),
    STRONG_REJECT(3),
    REJECT(2),
    WEAK_REJECT(1);


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
