package com.my_bank.myBank.domain.outcome.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class OutcomeResponseDto {
    private Long outcomeId;
    private Long userId;
    private String name;
    private Long price;
    private String date;
    private String accountingCategoriesStatus;
    private String outComeCategory;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
