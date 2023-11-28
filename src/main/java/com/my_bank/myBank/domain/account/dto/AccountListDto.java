package com.my_bank.myBank.domain.account.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AccountListDto {
    List<AccountResponseDto> acountResponseDtoList;
}
