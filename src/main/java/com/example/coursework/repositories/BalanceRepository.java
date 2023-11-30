package com.example.coursework.repositories;

import com.example.coursework.models.entity.Balance;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author max_pri
 */
@Repository
public interface BalanceRepository extends JpaRepository<Balance, Integer> {
}
