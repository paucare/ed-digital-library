package com.iesam.digLibrary.features.loans.domain;

import java.util.List;

public class GetActiveLoansUseCase {
    private LoanRepository repository;

    public GetActiveLoansUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> execute(){
        return repository.getActiveLoans();
    }
}
