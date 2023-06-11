package com.app.develite.user;

public class UserGetMapper {
public static UserGetDto toDTO(User admin){
    return UserGetDto.build(admin.getId(),admin.getUsername(),admin.getFirstname(),admin.getLastname(),admin.getEmail(),admin.getPhone_number(),admin.getAddress(),admin.getRole());
}
}
