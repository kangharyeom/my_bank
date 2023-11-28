package com.my_bank.myBank.domain.account.repository;

import com.my_bank.myBank.domain.account.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "select * from Accounts where user_id = :userId", nativeQuery = true)
    Account findByUserId(@Param("userId") long userId);

    Optional<Account> findByAccountId(Long accountId);

}
