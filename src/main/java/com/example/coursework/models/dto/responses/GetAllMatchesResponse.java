package com.example.coursework.models.dto.responses;

import com.example.coursework.models.dto.MatchDto;
import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @author max_pri
 */
@Data
@Builder
public class GetAllMatchesResponse {
    private List<MatchDto> matches;
}
