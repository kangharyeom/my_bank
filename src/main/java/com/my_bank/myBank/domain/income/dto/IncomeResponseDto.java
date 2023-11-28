package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class IncomeResponseDto {
    private Long IncomeId;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
