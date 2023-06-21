package com.app.develite.project;

import java.sql.Date;
import java.util.Set;

import com.app.develite.client.Client;

import com.app.develite.tasks.Task;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "project",uniqueConstraints=
                    {@UniqueConstraint(columnNames="title",name ="unique_title")})
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY, generator = "exception_seq_generator")
    @Column(name="id" , columnDefinition = "BIGINT")
    private Long id;

    @NotNull(message="title name cannot be null.")
    @NotEmpty(message = "title name cannot be empty.")
    @Column(name="title",columnDefinition =  "VARCHAR(45)",nullable = false)
    private String title;

    @OneToOne
    @JoinColumn(name = "client_id", referencedColumnName = "id", nullable = false)
    private Client client;


    @Column(name="service",columnDefinition = "VARCHAR(60)")
    @Enumerated(EnumType.STRING)
    private Services service;

    @NotNull(message="description name cannot be null.")
    @NotEmpty(message = "description name cannot be empty.")
    @Column(name="description",columnDefinition =  "VARCHAR(200)",nullable = false)
    private String description;

    @NotNull(message="website name cannot be null.")
    @NotEmpty(message = "website name cannot be empty.")
    @Column(name="website",columnDefinition =  "VARCHAR(45)",nullable = false)
    private String website;

    @Column(name="status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @NotNull(message="submit date cannot be null.")
    @Column (name="submit_Date", nullable=false)
    private Date submit_date;

    @NotNull(message="start date cannot be null.")
    @Column (name="start_date", nullable=false)
    private Date start_date;

    @NotNull(message="end date cannot be null.")
    @Column (name="end_date", nullable=false)
    private Date end_date;


    @OneToMany(mappedBy="project", fetch =FetchType.LAZY)
    private Set <Task> tasks;



}
