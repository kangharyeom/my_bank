package com.my_bank.myBank.domain.outcome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OutcomePostDto {
    private Long outcomeId;
    private Long userId;
    private Long accountId;
    private String name;
    private Long price;
    private String date;
    private String accountingCategoriesStatus;
    private String outComeCategory;
}
