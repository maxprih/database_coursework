package com.example.coursework.models.dto.requests;

import com.example.coursework.models.dto.MatchEventDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Set;

/**
 * @author max_pri
 */
@Data
public class MakeBetRequest {
    private Integer amount;
    @JsonProperty("match_events")
    private Set<Integer> ids;
}
