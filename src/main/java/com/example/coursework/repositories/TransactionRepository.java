package com.example.coursework.repositories;

import com.example.coursework.models.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author max_pri
 */
@Repository
public interface TransactionRepository extends JpaRepository<Transaction, Integer> {
    List<Transaction> getTransactionByUserId(Integer userId);
}
