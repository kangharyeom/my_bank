package com.my_bank.myBank.domain.income.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
@Builder
public class IncomeResponseDto {
    private Long incomeId;
    private Long userId;
    private String name;
    private Long price;
    private String date;
    private String accountingCategoriesStatus;
    private String inComeCategory;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    @Override
    public String toString() {
        return "IncomeResponseDto{" +
                "incomeId=" + incomeId +
                ", userId=" + userId +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", date='" + date + '\'' +
                ", accountingCategoriesStatus='" + accountingCategoriesStatus + '\'' +
                ", inComeCategory='" + inComeCategory + '\'' +
                ", createdAt=" + createdAt +
                ", modifiedAt=" + modifiedAt +
                '}';
    }
}
