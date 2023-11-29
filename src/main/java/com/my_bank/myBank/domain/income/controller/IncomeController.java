package com.my_bank.myBank.domain.income.controller;

import com.my_bank.myBank.domain.income.dto.IncomePatchDto;
import com.my_bank.myBank.domain.income.dto.IncomePostDto;
import com.my_bank.myBank.domain.income.dto.IncomeResponseDto;
import com.my_bank.myBank.domain.income.entity.Income;
import com.my_bank.myBank.domain.income.mapper.IncomeMapper;
import com.my_bank.myBank.domain.income.service.IncomeService;
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
@RequestMapping("/api/incomes")
public class IncomeController {

    private final IncomeService incomeService;
    private final IncomeMapper incomeMapper;
    @PostMapping
    public ResponseEntity postIncome(@Valid @RequestBody IncomePostDto requestBody ){
        Income income = incomeService.createIncome(
                incomeMapper.incomePostDtoToIncome(requestBody),
                requestBody.getUserId(),
                requestBody.getAccountId()
        );
        IncomeResponseDto incomeResponseDto = incomeMapper.incomeToIncomeResponseDto(income);
        log.info("incomeResponseDto: {}", incomeResponseDto.toString());


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

    @GetMapping
    public ResponseEntity getIncomes(@Positive @RequestParam(value = "page", defaultValue = "1") int page,
                                      @Positive @RequestParam(value = "size", defaultValue = "40") int size){

        Page<Income> pageContents = incomeService.findIncomes(page - 1, size);
        List<Income> incomes = pageContents.getContent();
        log.info("전체 요청 :" + incomes);
        return new ResponseEntity<>(
                new MultiResponseDto<>(incomeMapper.incomesToIncomeResponse(incomes),
                        pageContents),
                HttpStatus.OK);
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

