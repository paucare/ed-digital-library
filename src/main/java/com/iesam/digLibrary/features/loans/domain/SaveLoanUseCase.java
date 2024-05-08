package com.iesam.digLibrary.features.loans.domain;

public class SaveLoanUseCase {
    private LoanRepository repository;

    public SaveLoanUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public void execute(Loan loan){
         repository.saveLoan(loan);
    }


}
