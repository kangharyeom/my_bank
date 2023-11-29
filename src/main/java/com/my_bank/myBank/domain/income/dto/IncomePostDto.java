package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IncomePostDto {
    private Long incomeId;
    private Long userId;
    @NonNull
    private String name;
    @NonNull
    private Long price;
    @NonNull
    private String date;
    @NonNull
    private String accountingCategoriesStatus;
    @NonNull
    private String inComeCategory;
}
