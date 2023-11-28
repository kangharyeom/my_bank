package com.my_bank.myBank.domain.income.controller;

import com.my_bank.myBank.domain.income.dto.IncomePatchDto;
import com.my_bank.myBank.domain.income.dto.IncomePostDto;
import com.my_bank.myBank.domain.income.dto.IncomeResponseDto;
import com.my_bank.myBank.domain.income.entity.Income;
import com.my_bank.myBank.domain.income.mapper.IncomeMapper;
import com.my_bank.myBank.domain.income.service.IncomeService;
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
@RequestMapping("/api/incomes")
public class IncomeController {

    private final IncomeService incomeService;
    private final IncomeMapper incomeMapper;
    @PostMapping
    public ResponseEntity postIncome(@Valid @RequestBody IncomePostDto requestBody ){
        Income income = incomeService.createIncome(
                incomeMapper.incomePostDtoToIncome(requestBody),
                requestBody.getUserId()
        );
        IncomeResponseDto incomeResponseDto = incomeMapper.incomeToIncomeResponseDto(income);
        log.info("IncomeResponseDto.getIncomeId() : {}", incomeResponseDto.getIncomeId());
        log.info("IncomeResponseDto.getUserId() : {}", incomeResponseDto.getUserId());
        log.info("requestBody.getUserId() : {}", requestBody.getUserId());

        return ResponseEntity.ok(incomeResponseDto);
    }

    @PatchMapping("/{incomeId}")
    public ResponseEntity patchIncome(@Valid @RequestBody IncomePatchDto requestBody,
                                       @PathVariable("IncomeId") @Positive Long incomeId){
        requestBody.updateId(incomeId);
        Income income = incomeService.updateIncome(
                incomeMapper.incomePatchDtoToIncome(requestBody));

        IncomeResponseDto incomeResponseDto = incomeMapper.incomeToIncomeResponseDto(income);

        return ResponseEntity.ok(incomeResponseDto);
    }

    @GetMapping("/{incomeId}")
    public ResponseEntity getIncome(@PathVariable("incomeId") @Positive Long incomeId){
        Income income = incomeService.findIncome(incomeId);
        IncomeResponseDto incomeResponse = incomeMapper.incomeToIncomeResponseDto(income);
        log.info("팀 리스 폰스 {}",incomeResponse);

        return ResponseEntity.ok(incomeResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getIncomeByUserId(@PathVariable("userId") @Positive Long userId){
        Income income = incomeService.findIncomeByUserId(userId);
        IncomeResponseDto incomeResponse = incomeMapper.incomeToIncomeResponseDto(income);

        return ResponseEntity.ok(incomeResponse);
    }

    @DeleteMapping("/{incomeId}")
    public ResponseEntity deleteIncome(@PathVariable("incomeId") @Positive Long incomeId) {
        incomeService.deleteIncome(incomeId);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}

