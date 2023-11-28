package com.my_bank.myBank.domain.outcome.service;

import com.my_bank.myBank.domain.outcome.entity.Outcome;
import com.my_bank.myBank.domain.outcome.repository.OutcomeRepository;
import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.domain.user.repository.UserRepository;
import com.my_bank.myBank.domain.user.service.UserService;
import com.my_bank.myBank.global.exception.BusinessLogicException;
import com.my_bank.myBank.global.exception.Exceptions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class OutcomeService {
    private final OutcomeRepository outcomeRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    public Outcome createOutcome(
            Outcome outcome, Long userId) {
        findVerifiedExistsOutcomeByUserId(userId);
        User user = userService.findUser(userId);

        outcome.setUser(user);

        userRepository.save(user);

        return outcomeRepository.save(outcome);
    }

    public Outcome updateOutcome(
            Outcome outcome) {

        Outcome findOutcome = findVerifiedOutcome(outcome.getOutcomeId()); //ID로 멤버 존재 확인하고 comment 정보 반환

//        Optional.ofNullable(Outcome.getUniformType())
//                .ifPresent(findOutcome::setUniformType);

        return outcomeRepository.save(findOutcome);
    }

    public Outcome findOutcome(long outcomeId) {
        return findVerifiedOutcome(outcomeId);
    }

    public Outcome findOutcomeByUserId(long userId) {
        return findVerifiedOutcomeByUserId(userId);
    }

//    public Page<Outcome> findOutcomes(int page, int size) {
//        return outcomeRepository.findAll(PageRequest.of(page, size,
//                Sort.by("outcomeId").descending()));
//    }

    public Outcome findOutcome(int outcomeId) {
        return findVerifiedOutcome(outcomeId);
    }

    public void deleteOutcome(long outcomeId) {
        Outcome findOutcome = findVerifiedOutcome(outcomeId);

        outcomeRepository.delete(findOutcome);
    }

    public Outcome findVerifiedOutcome(long outcomeId) {
        Optional<Outcome> optionalOutcome = outcomeRepository.findById(outcomeId);
        return optionalOutcome.orElseThrow(() ->
                        new BusinessLogicException(Exceptions.OUTCOME_NOT_FOUND));
    }

    public Outcome findVerifiedOutcomeByUserId(long userId) {
        Outcome outcome;
        try {
            outcome = outcomeRepository.findByUserId(userId);
        } catch (NoSuchElementException ex) {
            throw new BusinessLogicException(Exceptions.OUTCOME_NOT_FOUND);
        }
        return outcome;
    }

    public Outcome findVerifiedExistsOutcomeByUserId(long userId) {
        Outcome outcome = outcomeRepository.findByUserId(userId);
        if(outcome ==null) {
                throw new BusinessLogicException(Exceptions.OUTCOME_EXISTS);
        }
        return outcome;
    }
}
