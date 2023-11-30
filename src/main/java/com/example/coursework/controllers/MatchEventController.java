package com.example.coursework.controllers;

import com.example.coursework.models.dto.requests.ChangeEventRequest;
import com.example.coursework.services.MatchEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

/**
 * @author max_pri
 */
@RestController
@RequestMapping("api/v1/events")
public class MatchEventController {
    private final MatchEventService matchEventService;

    @Autowired
    public MatchEventController(MatchEventService matchEventService) {
        this.matchEventService = matchEventService;
    }

    @PutMapping("/change")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<?> changeEventStatus(@RequestBody ChangeEventRequest request) {
        matchEventService.changeEventStatus(request);

        return ResponseEntity.ok().build();
    }
}
