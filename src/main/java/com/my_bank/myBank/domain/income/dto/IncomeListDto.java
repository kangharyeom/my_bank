package com.my_bank.myBank.domain.income.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class IncomeListDto {
    List<IncomeResponseDto> acountResponseDtoList;
}
