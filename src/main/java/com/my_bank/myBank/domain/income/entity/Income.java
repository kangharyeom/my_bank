package com.my_bank.myBank.domain.income.entity;

import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.global.audit.Auditable;
import com.my_bank.myBank.global.constant.AccountingCategoriesStatus;
import com.my_bank.myBank.global.constant.InComeCategory;
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
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private Long price;
    @Column(nullable = false)
    private String date;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
        private AccountingCategoriesStatus accountingCategoriesStatus;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private InComeCategory inComeCategory;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID",nullable = false)
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ACCOUNT_ID",nullable = false)
    private Account account;
}
