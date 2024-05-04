package com.iesam.digLibrary.features.loans.domain;

public class DeleteLoanUseCase {
    private LoanRepository repository;

    public DeleteLoanUseCase(LoanRepository repository) {
        this.repository = repository;
    }
    public void execute(int loanId){
        repository.deleteLoan(loanId);
    }
}
