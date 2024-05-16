package com.iesam.digLibrary.features.loans.domain;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(MockitoExtension.class)
class CheckIfBookIsLoanedUseCaseTest {
    @Mock
    LoanRepository repository;
    @BeforeEach
    void setUp() {
    }

    @AfterEach
    void tearDown() {
    }
}