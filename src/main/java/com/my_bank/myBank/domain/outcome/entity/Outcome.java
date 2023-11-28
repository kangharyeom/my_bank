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

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID")
    private User user;

    private String name;

    private Long price;

    @Enumerated
    private AccountingCategoriesStatus accountingCategoriesStatus;

    @Enumerated
    private OutComeCategory outComeCategory;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "ACCOUNT_ID")
    private Account account;
}
