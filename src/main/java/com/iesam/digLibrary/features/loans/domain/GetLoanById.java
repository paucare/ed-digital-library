package com.iesam.digLibrary.features.loans.domain;

public class GetLoanById {
    private LoanRepository repository;

    public GetLoanById(LoanRepository repository) {
        this.repository = repository;
    }
    public Loan execute(int id){
       return repository.getLoanById(id);
    }
}
