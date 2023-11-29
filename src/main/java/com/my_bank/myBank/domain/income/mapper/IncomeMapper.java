package com.my_bank.myBank.domain.income.mapper;

import com.my_bank.myBank.domain.income.dto.IncomeListDto;
import com.my_bank.myBank.domain.income.dto.IncomePatchDto;
import com.my_bank.myBank.domain.income.dto.IncomePostDto;
import com.my_bank.myBank.domain.income.dto.IncomeResponseDto;
import com.my_bank.myBank.domain.income.entity.Income;
import com.my_bank.myBank.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface IncomeMapper {
    Income incomePostDtoToIncome(IncomePostDto requestBody);

    Income incomePatchDtoToIncome(IncomePatchDto requestBody);

    default IncomeResponseDto incomeToIncomeResponseDto(Income income){
        User user = income.getUser();

        return IncomeResponseDto.builder()
                .userId(user.getUserId())
                .incomeId(income.getIncomeId())
                .outComeCategory(String.valueOf(income.getOutComeCategory()))
                .accountingCategoriesStatus(String.valueOf(income.getAccountingCategoriesStatus()))
                .price(income.getPrice())
                .name(income.getName())
                .date(income.getDate())
                .createdAt(income.getCreatedAt())
                .modifiedAt(income.getModifiedAt())
                .build();
    }

    default IncomeListDto incomeListDtoToIncomeResponse(List<Income> incomes){

        return IncomeListDto.builder()
                .acountResponseDtoList(incomesToIncomeResponse(incomes))
                .build();
    }

    List<IncomeResponseDto> incomesToIncomeResponse(List<Income> incomes);
}
