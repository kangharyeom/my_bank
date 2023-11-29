package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class IncomePostDto {
    private Long incomeId;
    private Long userId;
    @NotNull
    private String name;
    @NotNull
    private Long price;
    @NotNull
    private String date;
    @NotNull
    private String accountingCategoriesStatus;
    @NotNull
    private String outComeCategory;
}
