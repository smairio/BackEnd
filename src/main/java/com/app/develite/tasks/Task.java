package com.app.develite.tasks;

import java.sql.Date;


import com.app.develite.project.Status;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "task",uniqueConstraints=
                    {@UniqueConstraint(columnNames="title",name ="unique_titme")})
public class Task {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "exception_seq_generator")
    @Column(name="id" , columnDefinition = "BIGINT")
    private Long id;

    @NotNull(message="title cannot be null.")
    @NotEmpty(message = "title cannot be empty.")
    @Column(name="title",columnDefinition =  "VARCHAR(45)",nullable = false)
    private String title;

    @NotNull(message="description name cannot be null.")
    @NotEmpty(message = "description name cannot be empty.")
    @Column(name="description",columnDefinition =  "VARCHAR(45)",nullable = false)
    private String description;


    @NotNull(message="start date cannot be null.")
    @Column (name="start_date", nullable=false)
    private Date start_date;

    @NotNull(message="end date cannot be null.")
    @Column (name="end_date", nullable=false)
    private Date end_date;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;



}
