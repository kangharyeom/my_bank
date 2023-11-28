package com.my_bank.myBank.domain.outcome.dto;

import com.my_bank.myBank.global.constant.AccountingCategoriesStatus;
import com.my_bank.myBank.global.constant.OutComeCategory;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OutcomePostDto {
    private Long outcomeId;
    private Long userId;
    private String name;
    private Long price;
    private String accountingCategoriesStatus;
    private String outComeCategory;
}
