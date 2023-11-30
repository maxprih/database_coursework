package com.example.coursework.services;

import com.example.coursework.exceptions.NoFreeMoneyException;
import com.example.coursework.models.dto.requests.WithdrawRequest;
import com.example.coursework.models.entity.Balance;
import com.example.coursework.models.entity.User;
import com.example.coursework.repositories.BalanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author max_pri
 */
@Service
public class BalanceService {
    private final BalanceRepository balanceRepository;
    private final TransactionService transactionService;
    private final UserRetrievalService userRetrievalService;

    @Autowired
    public BalanceService(BalanceRepository balanceRepository, TransactionService transactionService, UserRetrievalService userRetrievalService) {
        this.balanceRepository = balanceRepository;
        this.transactionService = transactionService;
        this.userRetrievalService = userRetrievalService;
    }

    public Balance createBalanceForUser(User user) {
        Balance balance = new Balance();
        balance.setUser(user);

        return balanceRepository.save(balance);
    }

    public Balance changeUserBalance(User user, Integer amount) {
        Balance balance = user.getBalance();
        transactionService.createNewTransaction(amount);
        balance.setAmount(balance.getAmount() + amount);
        return balanceRepository.save(balance);
    }

    public void addFreeMoney() {
        User user = userRetrievalService.getUserFromContext();
        if (user.getBalance().getAmount() < 500) {
            changeUserBalance(user, 50);
        } else {
            throw new NoFreeMoneyException();
        }
    }

    public void withdraw(WithdrawRequest request) {
        User user = userRetrievalService.getUserFromContext();
        changeUserBalance(user, -request.getAmount());
    }
}
