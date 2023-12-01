package com.example.coursework.models.dto.requests;

import com.example.coursework.models.entity.enums.MatchEventStatus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author max_pri
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonSerialize
public class CreateMatchEventRequest {
    private Integer matchId;
    private String name;
    private Double coefficient;
    private MatchEventStatus status;
}