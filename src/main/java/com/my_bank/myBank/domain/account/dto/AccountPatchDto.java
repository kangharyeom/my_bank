package com.my_bank.myBank.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountPatchDto {
    private Long accountId;
    private Long userId;

    public void updateId(Long id){
        this.accountId = id;
    }
}
