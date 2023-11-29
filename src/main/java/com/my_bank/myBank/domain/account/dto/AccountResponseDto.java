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
    private String date;
    private String name;
    private String description;

    @Override
    public String toString() {
        return "AccountResponseDto{" +
                "accountId=" + accountId +
                ", userId=" + userId +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                ", date='" + date + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
