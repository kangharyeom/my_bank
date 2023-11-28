package com.my_bank.myBank.domain.user.mapper;

import com.my_bank.myBank.domain.user.dto.UserListDto;
import com.my_bank.myBank.domain.user.dto.UserPatchDto;
import com.my_bank.myBank.domain.user.dto.UserPostDto;
import com.my_bank.myBank.domain.user.dto.UserResponseDto;
import com.my_bank.myBank.domain.user.entity.User;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userPostDtoToUser(UserPostDto requestBody);

    User userPatchDtoToUser(UserPatchDto requestBody);

    // 회원 단건 조회
    default UserResponseDto userToUserResponseDto(User user) {
        return UserResponseDto.builder()
                .userId(user.getUserId())
                .loginId(user.getLoginId())
                .email(user.getEmail())
                .name(user.getName())
                .password(user.getPassword())
                .phone(user.getPhone())
                .createdAt(user.getCreatedAt())
                .modifiedAt(user.getModifiedAt())
                .build();
    }

    // 회원 전체 List
    default UserListDto usersToUserListResponse(List<User> userList) {
        return UserListDto.builder()
                .userResponseDto(usersToUsersResponse(userList))
                .build();
    }

    // 회원 response 리스트화
    List<UserResponseDto> usersToUsersResponse(List<User> users);
}
