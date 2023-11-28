package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IncomePostDto {
    private Long IncomeId;
    private Long userId;
}
