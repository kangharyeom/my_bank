package com.my_bank.myBank.domain.account.controller;

import com.my_bank.myBank.domain.account.dto.AccountPatchDto;
import com.my_bank.myBank.domain.account.dto.AccountPostDto;
import com.my_bank.myBank.domain.account.dto.AccountResponseDto;
import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.account.mapper.AccountMapper;
import com.my_bank.myBank.domain.account.service.AccountService;
import com.my_bank.myBank.global.response.MultiResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Positive;
import java.util.List;

@RestController
@Validated
@RequiredArgsConstructor
@Log4j2
@RequestMapping("/api/accounts")
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;
    @PostMapping
    public ResponseEntity<AccountResponseDto> postAccount(@Valid @RequestBody AccountPostDto requestBody ){
        Account account = accountService.createAccount(
                accountMapper.accountPostDtoToAccount(requestBody),
                requestBody.getUserId()
        );
        AccountResponseDto accountResponseDto = accountMapper.accountToAccountResponseDto(account);
        log.info("AccountResponseDto : {}", accountResponseDto.toString());

        return ResponseEntity.ok(accountResponseDto);
    }

    @PatchMapping("/{accountId}")
    public  ResponseEntity<AccountResponseDto> patchAccount(@Valid @RequestBody AccountPatchDto requestBody,
                                       @PathVariable("accountId") @Positive Long accountId){
        requestBody.updateId(accountId);
        Account account = accountService.updateAccount(
                accountMapper.accountPatchDtoToAccount(requestBody));

        AccountResponseDto accountResponseDto = accountMapper.accountToAccountResponseDto(account);

        return ResponseEntity.ok(accountResponseDto);
    }

    @GetMapping("/{accountId}")
    public ResponseEntity<AccountResponseDto> getAccount(@PathVariable("accountId") @Positive Long accountId){
        Account account = accountService.findAccount(accountId);
        AccountResponseDto accountResponse = accountMapper.accountToAccountResponseDto(account);
        log.info("팀 리스 폰스 {}",accountResponse);

        return ResponseEntity.ok(accountResponse);
    }

    @GetMapping
    public ResponseEntity<MultiResponseDto<AccountResponseDto>> getContents(
            @Positive @RequestParam(value = "page", defaultValue = "1") int page,
            @Positive @RequestParam(value = "size", defaultValue = "40") int size){

        Page<Account> pageContents = accountService.findAccounts(page - 1, size);
        List<Account> accounts = pageContents.getContent();
        log.info("전체 요청 :" + accounts);
        return new ResponseEntity<>(
                new MultiResponseDto<>(accountMapper.accountsToAccountResponse(accounts),
                        pageContents),
                HttpStatus.OK);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<AccountResponseDto> getAccountByUserId(@PathVariable("userId") @Positive Long userId){
        Account account = accountService.findAccountByUserId(userId);
        AccountResponseDto accountResponse = accountMapper.accountToAccountResponseDto(account);

        return ResponseEntity.ok(accountResponse);
    }

    @DeleteMapping("/{accountId}")
    public ResponseEntity<HttpStatus> deleteAccount(@PathVariable("accountId") @Positive Long accountId) {
        accountService.deleteAccount(accountId);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}

