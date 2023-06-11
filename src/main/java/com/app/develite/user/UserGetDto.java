package com.app.develite.user;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor(staticName = "build")
@NoArgsConstructor
public class UserGetDto {
    private Long id;
    private String username;
    private String firstname;
    private String lastname;
    private String email;
    private String phone_number;
    private String address;
    private Role role;


}
