package com.example.coursework.services;

import com.example.coursework.models.dto.TransactionDto;
import com.example.coursework.models.entity.Transaction;
import com.example.coursework.models.entity.User;
import com.example.coursework.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

/**
 * @author max_pri
 */
@Service
public class TransactionService {
    private final TransactionRepository transactionRepository;
    private final UserRetrievalService userRetrievalService;

    @Autowired
    public TransactionService(TransactionRepository transactionRepository, UserRetrievalService userRetrievalService) {
        this.transactionRepository = transactionRepository;
        this.userRetrievalService = userRetrievalService;
    }

    public List<TransactionDto> getAllTransactions() {
        User user = userRetrievalService.getUserFromContext();

        List<Transaction> transactions = transactionRepository.getTransactionByUserId(user.getId());

        return transactions.stream().map(transaction -> {
            String type = transaction.getAmount() >= 0 ? "Пополнение" : "Убыток";

            return TransactionDto.builder()
                    .amount(transaction.getAmount())
                    .type(type)
                    .date(transaction.getDate())
                    .id(transaction.getId())
                    .build();
        }).toList();
    }

    public void createNewTransaction(Integer amount) {
        User user = userRetrievalService.getUserFromContext();

        Transaction transaction = new Transaction();
        transaction.setAmount(amount);
        transaction.setDate(Instant.now());
        transaction.setUser(user);

        transactionRepository.save(transaction);
    }

}
