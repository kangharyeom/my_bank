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

    @Override
    public String toString() {
        return "OutcomeResponseDto{" +
                "outcomeId=" + outcomeId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", accountingCategoriesStatus='" + accountingCategoriesStatus + '\'' +
                ", outComeCategory='" + outComeCategory + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
