package com.my_bank.myBank.domain.outcome.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class OutcomePatchDto {
    private Long outcomeId;
    private Long userId;

    public void updateId(Long id){
        this.outcomeId = id;
    }
}
