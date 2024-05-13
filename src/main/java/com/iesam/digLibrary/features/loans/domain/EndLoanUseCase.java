package com.iesam.digLibrary.features.loans.domain;

import java.util.Date;

public class EndLoanUseCase {
        private LoanRepository repository;

        public EndLoanUseCase(LoanRepository repository) {
            this.repository = repository;
        }

        public void execute(int loanId){
            Loan loan = repository.getLoanById(loanId);
            Date currentDate = new Date();
            Loan loanFinished = new Loan(loan.loanId, loan.resource, loan.user, loan.loanDate,loan.expectedDate ,currentDate);
            repository.deleteLoan(loanId);
            repository.saveLoan(loanFinished);
        }
    }
















