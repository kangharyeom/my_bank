package com.my_bank.myBank.domain.outcome.repository;

import com.my_bank.myBank.domain.outcome.entity.Outcome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface OutcomeRepository extends JpaRepository<Outcome, Long> {
    @Query(value = "select * from Outcomes where user_id = :userId", nativeQuery = true)
    Outcome findByUserId(@Param("userId") long userId);

    Optional<Outcome> findByOutcomeId(Long outcomeId);

}
