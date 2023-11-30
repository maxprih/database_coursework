package com.example.coursework.models.dto;

import com.example.coursework.models.entity.enums.MatchEventStatus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author max_pri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MatchEventDto implements Serializable {
    private Integer id;
    private String name;
    private Double coefficient;
    private Integer matchId;
    private String matchFirstPlayerName;
    private String matchSecondPlayerName;
    @JsonSerialize(using = CustomInstantSerializer.class)
    private Instant matchDate;
    private MatchEventStatus status;
}
