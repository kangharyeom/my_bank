package com.my_bank.myBank.domain.income.entity;

import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.global.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "INCOMES")
public class Income extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long incomeId;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
}
