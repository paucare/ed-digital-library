package com.iesam.digLibrary.features.loans.domain;

import java.util.List;

public class GetFinishedLoansUseCase {
    private LoanRepository repository;

    public GetFinishedLoansUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> execute(){
        return repository.getActiveLoans();
    }
}
