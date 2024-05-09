package com.iesam.digLibrary.features.loans.domain;

public class EndLoanUseCase {
        private LoanRepository repository;

        public EndLoanUseCase(LoanRepository repository) {
            this.repository = repository;
        }

        public void execute(int loanId){
            Loan loan = repository.getLoanById(loanId);
            Loan loanFinished = new Loan(loan.loanId, loan.resource, loan.user, loan.loanDate,loan.expectedDate ,"Devuelto");
            repository.deleteLoan(loanId);
            repository.saveLoan(loanFinished);
        }
    }
















