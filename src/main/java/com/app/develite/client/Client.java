package com.app.develite.client;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Table(name = "client",uniqueConstraints=
                    {@UniqueConstraint(columnNames="companyname",name ="unique_company"),
                    @UniqueConstraint(columnNames="email",name ="unique_email")})

public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "exception_seq_generator")
    @Column(name="id" , columnDefinition = "BIGINT")
    private Long id;

    @NotNull(message="company name cannot be null.")
    @NotEmpty(message = "company name cannot be empty.")
    @Column(name="companyname",columnDefinition =  "VARCHAR(45)",nullable = false)
    private String companyname;

    @NotNull(message="firstname cannot be null.")
    @NotEmpty(message = "firstname cannot be empty.")
    @Column(name="firstname",columnDefinition = "VARCHAR(45)",nullable = false)
    private String firstname;

    @NotNull(message="lastname cannot be null.")
    @NotEmpty(message = "lastname cannot be empty.")
    @Column(name="lastname",columnDefinition = "VARCHAR(45)",nullable = false)
    private String lastname;

    @NotNull(message="email cannot be null.")
    @NotEmpty(message = "email cannot be empty.")
    @Column(name="email",columnDefinition = "VARCHAR(45)",  nullable = false)
    private String email;

    @NotNull(message="phone Number cannot be null.")
    @NotEmpty(message = "phone Number cannot be empty.")
    @Column(name="phonenumber",columnDefinition = "VARCHAR(8)",  nullable = false)
    private String phone_number;

    @Column(name="fax",columnDefinition = "VARCHAR(8)")
    private String fax;

    @NotNull(message="address cannot be null.")
    @NotEmpty(message = "address cannot be empty.")
    @Column(name="address",columnDefinition = "VARCHAR(150)")
    private String address;
    
    @Column(name="gender",columnDefinition = "VARCHAR(6)")
    @Enumerated(EnumType.STRING)
    private Gender gender;

}
