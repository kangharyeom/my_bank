package com.my_bank.myBank.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountPostDto {
    private Long accountId;
    private Long userId;
    private String date;
}
