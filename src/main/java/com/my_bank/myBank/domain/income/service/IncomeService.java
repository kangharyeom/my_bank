package com.my_bank.myBank.domain.income.service;

import com.my_bank.myBank.domain.income.entity.Income;
import com.my_bank.myBank.domain.income.repository.IncomeRepository;
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
public class IncomeService {
    private final IncomeRepository IncomeRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    public Income createIncome(
            Income Income, Long userId) {
        findVerifiedExistsIncomeByUserId(userId);
        User user = userService.findUser(userId);

        Income.setUser(user);

        userRepository.save(user);

        return IncomeRepository.save(Income);
    }

    public Income updateIncome(
            Income income) {

        Income findIncome = findVerifiedIncome(income.getIncomeId()); //ID로 멤버 존재 확인하고 comment 정보 반환

//        Optional.ofNullable(Income.getUniformType())
//                .ifPresent(findIncome::setUniformType);

        return IncomeRepository.save(findIncome);
    }

    public Income findIncome(long incomeId) {
        return findVerifiedIncome(incomeId);
    }

    public Income findIncomeByUserId(long userId) {
        return findVerifiedIncomeByUserId(userId);
    }

//    public Page<Income> findIncomes(int page, int size) {
//        return IncomeRepository.findAll(PageRequest.of(page, size,
//                Sort.by("IncomeId").descending()));
//    }

    public Income findIncome(int incomeId) {
        return findVerifiedIncome(incomeId);
    }

    public void deleteIncome(long incomeId) {
        Income findIncome = findVerifiedIncome(incomeId);

        IncomeRepository.delete(findIncome);
    }

    public Income findVerifiedIncome(long incomeId) {
        Optional<Income> optionalIncome = IncomeRepository.findById(incomeId);
        return optionalIncome.orElseThrow(() ->
                        new BusinessLogicException(Exceptions.INCOME_NOT_FOUND));
    }

    public Income findVerifiedIncomeByUserId(long userId) {
        Income income;
        try {
            income = IncomeRepository.findByUserId(userId);
        } catch (NoSuchElementException ex) {
            throw new BusinessLogicException(Exceptions.INCOME_NOT_FOUND);
        }
        return income;
    }

    public Income findVerifiedExistsIncomeByUserId(long userId) {
        Income income = IncomeRepository.findByUserId(userId);
        if(income ==null) {
            throw new BusinessLogicException(Exceptions.INCOME_EXISTS);
        }
        return income;
    }
}
