package com.my_bank.myBank.domain.account.mapper;

import com.my_bank.myBank.domain.account.dto.AccountListDto;
import com.my_bank.myBank.domain.account.dto.AccountPatchDto;
import com.my_bank.myBank.domain.account.dto.AccountPostDto;
import com.my_bank.myBank.domain.account.dto.AccountResponseDto;
import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    Account accountPostDtoToAccount(AccountPostDto requestBody);

    Account accountPatchDtoToAccount(AccountPatchDto requestBody);

    default AccountResponseDto accountToAccountResponseDto(Account account){
        User user = account.getUser();

        return AccountResponseDto.builder()
                .userId(user.getUserId())
                .accountId(account.getAccountId())
                .date(account.getDate())
                .name(account.getName())
                .description(account.getDescription())
                .createdAt(account.getCreatedAt())
                .modifiedAt(account.getModifiedAt())
                .build();
    }

    default AccountListDto accountListDtoToAccountResponse(List<Account> accounts){

        return AccountListDto.builder()
                .acountResponseDtoList(accountsToAccountResponse(accounts))
                .build();
    }

    List<AccountResponseDto> accountsToAccountResponse(List<Account> accounts);
}
