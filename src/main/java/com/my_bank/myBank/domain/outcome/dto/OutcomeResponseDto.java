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
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
