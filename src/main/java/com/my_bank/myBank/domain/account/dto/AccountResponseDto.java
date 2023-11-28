package com.my_bank.myBank.domain.account.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class AccountResponseDto {
    private Long accountId;
    private Long userId;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
}
