package com.example.coursework.models.dto.requests;

import com.example.coursework.models.entity.enums.MatchEventStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author max_pri
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ChangeEventRequest {
    private Integer id;
    private MatchEventStatus status;
}
