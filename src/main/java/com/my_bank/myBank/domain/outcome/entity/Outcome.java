package com.my_bank.myBank.domain.outcome.entity;

import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.global.audit.Auditable;
import com.my_bank.myBank.global.constant.AccountingCategoriesStatus;
import com.my_bank.myBank.global.constant.OutComeCategory;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "OUTCOMES")
public class Outcome extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long outcomeId;

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
    private OutComeCategory outComeCategory;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID")
    private User user;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
}
