package com.my_bank.myBank.domain.income.repository;

import com.my_bank.myBank.domain.income.entity.Income;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IncomeRepository extends JpaRepository<Income, Long> {
    @Query(value = "select * from Incomes where user_id = :userId", nativeQuery = true)
    Income findByUserId(@Param("userId") long userId);

    Optional<Income> findByIncomeId(Long incomeId);

}