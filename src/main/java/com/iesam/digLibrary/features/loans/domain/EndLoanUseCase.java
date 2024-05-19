package com.iesam.digLibrary.features.loans.domain;

import java.util.Date;
import java.util.List;

public class EndLoanUseCase {
    private LoanRepository repository;

    public EndLoanUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public void execute(int bookId) {

        List<Loan> loanList = repository.getLoans();
        for (Loan element : loanList) {
            if (element.resource.id == bookId && element.isActive()) {
                Date currentDate = new Date();
                Loan loanFinished = new Loan(element.loanId, element.resource, element.user, element.loanDate, element.expectedDate, currentDate);
                repository.deleteLoan(element.loanId);
                repository.saveLoan(loanFinished);
            }
        }
    }
}

 /*Loan loan = repository.getLoanById(loanId);
            Date currentDate = new Date();
            Loan loanFinished = new Loan(loan.loanId, loan.resource, loan.user, loan.loanDate,loan.expectedDate ,currentDate);
            repository.deleteLoan(loanId);
            repository.saveLoan(loanFinished);
             */














