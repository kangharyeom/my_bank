package com.my_bank.myBank.domain.outcome.controller;

import com.my_bank.myBank.domain.outcome.dto.OutcomePatchDto;
import com.my_bank.myBank.domain.outcome.dto.OutcomePostDto;
import com.my_bank.myBank.domain.outcome.dto.OutcomeResponseDto;
import com.my_bank.myBank.domain.outcome.entity.Outcome;
import com.my_bank.myBank.domain.outcome.mapper.OutcomeMapper;
import com.my_bank.myBank.domain.outcome.service.OutcomeService;
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
@RequestMapping("/api/Outcomes")
public class OutcomeController {

    private final OutcomeService outcomeService;
    private final OutcomeMapper outcomeMapper;
    @PostMapping
    public ResponseEntity postOutcome(@Valid @RequestBody OutcomePostDto requestBody ){
        Outcome outcome = outcomeService.createOutcome(
                outcomeMapper.outcomePostDtoToOutcome(requestBody),
                requestBody.getUserId()
        );
        OutcomeResponseDto outcomeResponseDto = outcomeMapper.outcomeToOutcomeResponseDto(outcome);
        log.info("OutcomeResponseDto.getOutcomeId() : {}", outcomeResponseDto.getOutcomeId());
        log.info("OutcomeResponseDto.getUserId() : {}", outcomeResponseDto.getUserId());
        log.info("requestBody.getUserId() : {}", requestBody.getUserId());

        return ResponseEntity.ok(outcomeResponseDto);
    }

    @PatchMapping("/{outcomeId}")
    public ResponseEntity patchOutcome(@Valid @RequestBody OutcomePatchDto requestBody,
                                       @PathVariable("outcomeId") @Positive Long outcomeId){
        requestBody.updateId(outcomeId);
        Outcome outcome = outcomeService.updateOutcome(
                outcomeMapper.outcomePatchDtoToOutcome(requestBody));

        OutcomeResponseDto outcomeResponseDto = outcomeMapper.outcomeToOutcomeResponseDto(outcome);

        return ResponseEntity.ok(outcomeResponseDto);
    }

    @GetMapping("/{outcomeId}")
    public ResponseEntity getOutcome(@PathVariable("outcomeId") @Positive Long outcomeId){
        Outcome outcome = outcomeService.findOutcome(outcomeId);
        OutcomeResponseDto outcomeResponse = outcomeMapper.outcomeToOutcomeResponseDto(outcome);
        log.info("팀 리스 폰스 {}",outcomeResponse);

        return ResponseEntity.ok(outcomeResponse);
    }

    @GetMapping("/users/{userId}")
    public ResponseEntity getOutcomeByUserId(@PathVariable("userId") @Positive Long userId){
        Outcome outcome = outcomeService.findOutcomeByUserId(userId);
        OutcomeResponseDto outcomeResponse = outcomeMapper.outcomeToOutcomeResponseDto(outcome);

        return ResponseEntity.ok(outcomeResponse);
    }

    @DeleteMapping("/{outcomeId}")
    public ResponseEntity deleteOutcome(@PathVariable("outcomeId") @Positive Long outcomeId) {
        outcomeService.deleteOutcome(outcomeId);

        return ResponseEntity.ok(HttpStatus.NO_CONTENT);
    }
}

