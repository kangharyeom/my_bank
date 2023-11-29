package com.my_bank.myBank.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class AccountPatchDto {
    private Long accountId;
    private Long userId;
    private String date;
    private String name;
    private String description;

    public void updateId(Long id){
        this.accountId = id;
    }
}
