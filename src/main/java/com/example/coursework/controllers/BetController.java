package com.example.coursework.controllers;

import com.example.coursework.models.dto.BetDto;
import com.example.coursework.models.dto.requests.MakeBetRequest;
import com.example.coursework.services.BetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author max_pri
 */
@RestController
@RequestMapping("api/v1/bets")
public class BetController {
    private final BetService betService;

    @Autowired
    public BetController(BetService betService) {
        this.betService = betService;
    }

    @PostMapping()
    public ResponseEntity<?> makeBet(@RequestBody MakeBetRequest request) {
        betService.makeBet(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<List<BetDto>> getAllBets() {
        return ResponseEntity.ok(betService.getAllBets());
    }

}
