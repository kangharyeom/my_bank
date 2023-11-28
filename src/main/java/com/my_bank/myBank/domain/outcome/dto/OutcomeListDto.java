package com.my_bank.myBank.domain.outcome.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class OutcomeListDto {
    List<OutcomeResponseDto> acountResponseDtoList;
}
