package com.my_bank.myBank.domain.user.service;

import com.my_bank.myBank.domain.user.entity.User;
import com.my_bank.myBank.domain.user.repository.UserRepository;
import com.my_bank.myBank.global.exception.BusinessLogicException;
import com.my_bank.myBank.global.exception.Exceptions;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Log4j2
@Service
@Transactional
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    /*
    * 회원 가입
    * 회원가입시 role을 부여하고 비밀번호를 암호화함
    */
    public User createUser(User user) {
        verifiedUser(user.getEmail());

//        List<String> roles = authorityUtils.createRoles(user.getEmail());

//        String encryptPassword = passwordEncoder.encode(user.getPassword());
//        user.setPassword(encryptPassword);

        try {
            userRepository.save(user);
            log.info("유저 등록 완료 {}", user);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            return user;
        }
        return user;
    }

    // 회원 수정
    public User updateUser(User user) {
        // 회원 유무 확인
        User findUser = existUser(user.getUserId());

        // 새로 변경할 이메일 존재 유무 확인
        Optional.ofNullable(user.getEmail())
                .ifPresent(newEmail -> {
                    verifiedUser(findUser.getEmail());
                    findUser.setEmail(newEmail);
                });

        Optional.ofNullable(user.getPassword())
                .ifPresent(findUser::setPassword);

        Optional.ofNullable(user.getName())
                .ifPresent(findUser::setName);

        try {
            return userRepository.save(findUser);
        } catch (DataAccessException e) {
            log.error(e.getMessage(), e);
            return user;
        }
    }

    // 회원 단건 조회
    public User findUser(Long userId) {
        return existUser(userId);
    }

    // 회원 전체 조회
    public List<User> findAllUser() {
        return userRepository.findAll();
    }

    // 회원 탈퇴
    public void deleteUser(Long userId) {
        User findUser = existUser(userId);
        userRepository.delete(findUser);
    }

    // 회원 존재 유무 확인 메서드
    public User existUser(Long userId) {
        return userRepository.findById(userId).orElseThrow(() -> new BusinessLogicException(Exceptions.USER_NOT_FOUND));
    }

    // 아이디, 이메일 중복 검사
    public void verifiedUser(String email) {
        Optional<User> userEmail = userRepository.findByEmail(email);
        if(userEmail.isPresent()) {
            throw new BusinessLogicException(Exceptions.EMAIL_EXISTS);
        }
    }

    public void verifiedLoginId(String loginId) {
        Optional<User> userLoginId = userRepository.findByLoginId(loginId);
        if(userLoginId.isPresent()) {
            throw new BusinessLogicException(Exceptions.LOGIN_ID_EXISTS);
        }
    }


    public User findVerifiedUser(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User findUser =
                optionalUser.orElseThrow(() ->
                        new BusinessLogicException(Exceptions.USER_NOT_FOUND));
        return findUser;
    }

    public User findVerifiedUserByTeamMemberRole(long userId) {
        Optional<User> optionalUser = userRepository.findById(userId);
        User findUser =
                optionalUser.orElseThrow(() ->
                        new BusinessLogicException(Exceptions.USER_NOT_FOUND));
        return findUser;
    }
   /* // 로그인한 회원
    public User getLoginUser() {
        String email = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new BusinessLogicException(Exceptions.USER_NOT_FOUND));
    }

    // 본인만 접근 허용
    public void checkJwtAndUser(Long userId) {
        if (!getLoginUser().getUserId().equals(userId)) {
            throw new BusinessLogicException(Exceptions.ACCESS_FORBIDDEN);
        }
    }*/
}
