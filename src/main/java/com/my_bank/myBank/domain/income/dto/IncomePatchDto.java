package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IncomePatchDto {
    private Long incomeId;
    private Long userId;

    public void updateId(Long id){
        this.incomeId = id;
    }
}
