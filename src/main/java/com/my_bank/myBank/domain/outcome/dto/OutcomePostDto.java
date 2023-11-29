package com.my_bank.myBank.domain.outcome.dto;

import com.my_bank.myBank.global.constant.AccountingCategoriesStatus;
import com.my_bank.myBank.global.constant.OutComeCategory;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OutcomePostDto {
    private Long outcomeId;
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
