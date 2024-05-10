package com.iesam.digLibrary.features.loans.domain;

import java.util.List;

public class GetLoansUseCase {
    private LoanRepository repository;

    public GetLoansUseCase(LoanRepository repository) {
        this.repository = repository;
    }
    public List<Loan> excecute(){
        return repository.getLoans();
    }
}
