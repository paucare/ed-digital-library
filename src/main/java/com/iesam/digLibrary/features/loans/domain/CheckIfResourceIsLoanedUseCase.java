package com.iesam.digLibrary.features.loans.domain;
import java.util.List;

public class CheckIfResourceIsLoanedUseCase {
    private LoanRepository repository;

    public CheckIfResourceIsLoanedUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public boolean execute(int bookId){
        List<Loan> loanList = repository.getLoans();
        for(Loan element : loanList){
            if(element.resource.id == bookId && element.isActive()) {
                return true;
            }
        }
        return false;
    }
}
