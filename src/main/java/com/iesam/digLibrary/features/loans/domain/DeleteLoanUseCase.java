package com.iesam.digLibrary.features.loans.domain;

public class DeleteLoanUseCase {
    private LoanRepository repository;

    public DeleteLoanUseCase(LoanRepository repository) {
        this.repository = repository;
    }
    public void execute(long loanId){
        repository.deleteLoan(loanId);
    }
}
