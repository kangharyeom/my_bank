package com.my_bank.myBank.domain.account.entity;

import com.my_bank.myBank.domain.income.entity.Income;
import com.my_bank.myBank.domain.outcome.entity.Outcome;
import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.global.audit.Auditable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;


@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "ACCOUNTS")
public class Account extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accountId;
    @Column(nullable = false)
    private String date;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String description;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "USER_ID")
    private User user;

    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Income> incomes = new ArrayList<>();
    @OneToMany(mappedBy = "account", cascade = CascadeType.REMOVE)
    private List<Outcome> outcomes = new ArrayList<>();
}
