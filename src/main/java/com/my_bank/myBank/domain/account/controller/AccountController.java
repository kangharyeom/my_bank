package com.my_bank.myBank.domain.account.controller;

import com.my_bank.myBank.domain.account.dto.AccountPatchDto;
import com.my_bank.myBank.domain.account.dto.AccountPostDto;
import com.my_bank.myBank.domain.account.dto.AccountResponseDto;
import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.account.mapper.AccountMapper;
import com.my_bank.myBank.domain.account.service.AccountService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;

@RestController
@Validated
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    @PostMapping
    public ResponseEntity postAccount(@Valid @RequestBody AccountPostDto requestBody ){
        Account Account = accountService.createAccount(
                accountMapper.accountPostDtoToAccount(requestBody),
                requestBody.getUserId()
        );
        AccountResponseDto AccountResponseDto = accountMapper.accountToAccountResponseDto(Account);
        log.info("AccountResponseDto.getAccountId() : {}", AccountResponseDto.getAccountId());
        log.info("AccountResponseDto.getUserId() : {}", AccountResponseDto.getUserId());
        log.info("requestBody.getUserId() : {}", requestBody.getUserId());

        return ResponseEntity.ok(AccountResponseDto);
    }

    @PatchMapping("/{accountId}")
    public ResponseEntity patchAccount(@Valid @RequestBody AccountPatchDto requestBody,
                                       @PathVariable("accountId") @Positive Long accountId){
        requestBody.updateId(accountId);
        Account account = accountService.updateAccount(
                accountMapper.accountPatchDtoToAccount(requestBody));

        AccountResponseDto userResponseDto = accountMapper.accountToAccountResponseDto(account);

        return ResponseEntity.ok(userResponseDto);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity getAccount(@PathVariable("accountId") @Positive Long accountId){
        Account account = accountService.findAccount(accountId);
        AccountResponseDto accountResponse = accountMapper.accountToAccountResponseDto(account);
        log.info("팀 리스 폰스 {}",accountResponse);

        return ResponseEntity.ok(accountResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getAccountByUserId(@PathVariable("userId") @Positive Long userId){
        Account account = accountService.findAccountByUserId(userId);
        AccountResponseDto accountResponse = accountMapper.accountToAccountResponseDto(account);

        return ResponseEntity.ok(accountResponse);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity deleteAccount(@PathVariable("accountId") @Positive Long accountId) {
        accountService.deleteAccount(accountId);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}

