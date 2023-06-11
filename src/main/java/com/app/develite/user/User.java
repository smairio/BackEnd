package com.app.develite.user;



import java.util.Collection;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "user",uniqueConstraints=
                    {@UniqueConstraint(columnNames="username",name ="unique_username"),
                    @UniqueConstraint(columnNames="email",name ="unique_email")})


public class User implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "exception_seq_generator")
    @Column(name="id" , columnDefinition = "BIGINT")
    private Long id;
    
    @NotEmpty(message = "username cannot be empty")
    @NotBlank(message = "username cannot be empty.")
    @NotNull(message = "username Cannot be empty.")
    @Column(name="username",columnDefinition =  "VARCHAR(45)",nullable = false)
    private String username;

    @NotEmpty(message = "password cannot be empty")
    @NotBlank(message = "password cannot be empty.")
    @NotNull(message = "password Cannot be empty.")    @Column(name="password",columnDefinition = "VARCHAR(250)",nullable = false)
    private String password;

    @NotBlank(message = "firstname cannot be empty.")
    @Column(name="firstname",columnDefinition = "VARCHAR(45)",nullable = false)
    private String firstname;

    @NotBlank(message = "lastname cannot be empty.")
    @Column(name="lastname",columnDefinition = "VARCHAR(45)",nullable = false)
    private String lastname;

    @NotBlank(message = "email cannot be empty.")
    @Column(name="email",columnDefinition = "VARCHAR(45)",  nullable = false)
    private String email;

    @NotBlank(message = "phone Number cannot be empty.")
    @Column(name="phonenumber",columnDefinition = "VARCHAR(45)",  nullable = false)
    private String phone_number;
    
    @NotBlank(message = "address cannot be empty.")
    @Column(name="address",columnDefinition = "VARCHAR(150)")
    private String address;

    @Enumerated(EnumType.STRING)
    @Column(name = "role")
    private Role role;

    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername(){
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }
    @Override
    public boolean isAccountNonExpired() {
            return true;
    }

    @Override
    public boolean isAccountNonLocked() {
            return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
            return true;
    }

    @Override
    public boolean isEnabled() {
                return true;
    }


    


}

