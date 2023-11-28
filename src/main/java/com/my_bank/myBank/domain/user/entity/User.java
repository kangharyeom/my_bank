package com.my_bank.myBank.domain.user.entity;

import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.global.audit.Auditable;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "USERS")
public class User extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true, updatable = false)
    private String loginId;

    @Email
    @NotBlank(message = "이메일을 입력해주세요.")
    private String email;

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String phone;

    @OneToMany(mappedBy = "user", cascade = CascadeType.REMOVE)
    private List<Account> accounts = new ArrayList<>();
}