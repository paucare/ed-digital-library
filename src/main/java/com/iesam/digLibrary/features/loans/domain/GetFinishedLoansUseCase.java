package com.iesam.digLibrary.features.loans.domain;

import java.util.ArrayList;
import java.util.List;

public class GetFinishedLoansUseCase {
    private LoanRepository repository;

    public GetFinishedLoansUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public List<Loan> execute(){
        List <Loan>  Loans= repository.getLoans();
        List<Loan> finishedLoans = new ArrayList<>();
        for(Loan element : Loans){
            if(!element.isActive()) {
                finishedLoans.add(element);
            }
        }
        return finishedLoans;
    }
}
