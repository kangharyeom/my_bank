package com.my_bank.myBank.domain.outcome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OutcomePostDto {
    private Long outcomeId;
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
    private String outComeCategory;
}
