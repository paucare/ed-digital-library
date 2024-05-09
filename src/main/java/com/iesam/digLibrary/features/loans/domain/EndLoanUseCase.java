package com.iesam.digLibrary.features.loans.domain;

public class EndLoanUseCase {
        private LoanRepository repository;

        public EndLoanUseCase(LoanRepository repository) {
            this.repository = repository;
        }
        public void execute(Loan loan){
            repository.endLoan(loan);
        }
    }















