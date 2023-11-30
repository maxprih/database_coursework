package com.example.coursework.controllers;

import com.example.coursework.models.dto.requests.WithdrawRequest;
import com.example.coursework.services.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author max_pri
 */
@RestController
@RequestMapping("api/v1/balance")
@CrossOrigin(origins = "http://localhost:8081")
public class BalanceController {
    private final BalanceService balanceService;

    @Autowired
    public BalanceController(BalanceService balanceService) {
        this.balanceService = balanceService;
    }

    @PostMapping("/free")
    public ResponseEntity<?> addFreeMoney() {
        balanceService.addFreeMoney();
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/withdraw")
    public ResponseEntity<?> withdraw(@RequestBody WithdrawRequest request) {
        balanceService.withdraw(request);
        return ResponseEntity.ok().build();
    }
}
