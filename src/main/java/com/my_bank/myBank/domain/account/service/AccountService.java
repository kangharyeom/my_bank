package com.my_bank.myBank.domain.account.service;

import com.my_bank.myBank.domain.account.entity.Account;
import com.my_bank.myBank.domain.account.repository.AccountRepository;
import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.domain.user.repository.UserRepository;
import com.my_bank.myBank.domain.user.service.UserService;
import com.my_bank.myBank.global.exception.BusinessLogicException;
import com.my_bank.myBank.global.exception.Exceptions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository accountRepository;
    private final UserRepository userRepository;
    private final UserService userService;
    public Account createAccount(
            Account account, Long userId) {
        findVerifiedExistsAccountByUserId(userId);
        User user = userService.findUser(userId);

        account.setUser(user);

        userRepository.save(user);

        return accountRepository.save(account);
    }

    public Account updateAccount(
            Account account) {

        Account findAccount = findVerifiedAccount(account.getAccountId()); //ID로 멤버 존재 확인하고 comment 정보 반환

//        Optional.ofNullable(Account.getUniformType())
//                .ifPresent(findAccount::setUniformType);

        return accountRepository.save(findAccount);
    }

    public Account findAccount(long accountId) {
        return findVerifiedAccount(accountId);
    }

    public Account findAccountByUserId(long userId) {
        return findVerifiedAccountByUserId(userId);
    }

//    public Page<Account> findAccounts(int page, int size) {
//        return accountRepository.findAll(PageRequest.of(page, size,
//                Sort.by("accountId").descending()));
//    }

    public Account findAccount(int accountId) {
        return findVerifiedAccount(accountId);
    }

    public void deleteAccount(long accountId) {
        Account findAccount = findVerifiedAccount(accountId);

        accountRepository.delete(findAccount);
    }

    public Account findVerifiedAccount(long accountId) {
        Optional<Account> optionalAccount = accountRepository.findById(accountId);
        Account findAccount =
                optionalAccount.orElseThrow(() ->
                        new BusinessLogicException(Exceptions.ACCOUNT_NOT_FOUND));
        return findAccount;
    }

    public Account findVerifiedAccountByUserId(long userId) {
        Account account;
        try {
            account = accountRepository.findByUserId(userId);
        } catch (NoSuchElementException ex) {
            throw new BusinessLogicException(Exceptions.ACCOUNT_NOT_FOUND);
        }
        return account;
    }

    public Account findVerifiedExistsAccountByUserId(long userId) {
        Account account = accountRepository.findByUserId(userId);
        if(account ==null) {
            try {
            } catch (NoSuchElementException ex) {
                throw new BusinessLogicException(Exceptions.ACCOUNT_EXISTS);
            }
        return account;
        }
        throw new BusinessLogicException(Exceptions.ACCOUNT_EXISTS);
    }
}
