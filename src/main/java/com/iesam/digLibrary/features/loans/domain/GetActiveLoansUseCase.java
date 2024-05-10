package com.iesam.digLibrary.features.loans.domain;

import java.util.ArrayList;
import java.util.List;

public class GetActiveLoansUseCase {
    private LoanRepository repository;

    public GetActiveLoansUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> execute(){
        List <Loan>  Loans= repository.getLoans();
        List<Loan> activeLoans = new ArrayList<>();
        for(Loan element : Loans){
            if(element.isActive()) {
                activeLoans.add(element);
            }
        }
        return activeLoans;
    }
}
