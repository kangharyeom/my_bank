package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IncomePostDto {
    private Long incomeId;
    private Long userId;
    private String name;
    private Long price;
    private String date;
    private String accountingCategoriesStatus;
    private String inComeCategory;
}
