package com.als.SMore.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "study_problem_bank")
public class StudyProblemBank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "problem_code_bank_pk")
    private Long problemCodeBankPk;

    @ManyToOne
    @JoinColumn(name = "study_pk", nullable = false)
    private Study study;

    @Column(name = "study_name", nullable = false)
    private String studyName;

    @Column(name = "group_name", nullable = false)
    private String groupName;

    // Getters and Setters
}