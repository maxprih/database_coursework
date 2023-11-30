package com.example.coursework.models.entity.enums;

/**
 * @author max_pri
 */
public enum BetStatus {
    WIN("win"),
    LOSE("lose"),
    TBD("tbd");

    public final String value;

    BetStatus(String value) {
        this.value = value;
    }
}
