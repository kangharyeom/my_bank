package com.my_bank.myBank.domain.outcome.mapper;

import com.my_bank.myBank.domain.outcome.dto.OutcomeListDto;
import com.my_bank.myBank.domain.outcome.dto.OutcomePatchDto;
import com.my_bank.myBank.domain.outcome.dto.OutcomePostDto;
import com.my_bank.myBank.domain.outcome.dto.OutcomeResponseDto;
import com.my_bank.myBank.domain.outcome.entity.Outcome;
import com.my_bank.myBank.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface OutcomeMapper {
    Outcome outcomePostDtoToOutcome(OutcomePostDto requestBody);

    Outcome outcomePatchDtoToOutcome(OutcomePatchDto requestBody);

    default OutcomeResponseDto outcomeToOutcomeResponseDto(Outcome outcome){
        User user = outcome.getUser();

        return OutcomeResponseDto.builder()
                .userId(user.getUserId())
                .outcomeId(outcome.getOutcomeId())
                .outComeCategory(String.valueOf(outcome.getOutComeCategory()))
                .accountingCategoriesStatus(String.valueOf(outcome.getAccountingCategoriesStatus()))
                .price(outcome.getPrice())
                .name(outcome.getName())
                .outcomeId(outcome.getOutcomeId())
                .createdAt(outcome.getCreatedAt())
                .modifiedAt(outcome.getModifiedAt())
                .build();
    }

    default OutcomeListDto outcomeListDtoToOutcomeResponse(List<Outcome> outcomes){

        return OutcomeListDto.builder()
                .acountResponseDtoList(outcomesToOutcomeResponse(outcomes))
                .build();
    }

    List<OutcomeResponseDto> outcomesToOutcomeResponse(List<Outcome> outcomes);
}
