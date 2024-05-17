package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.loans.data.LoanDataRepository;
import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.resources.books.domain.BooksRepository;

import java.util.List;

public class CheckIfBookIsLoanedUseCase {
    private LoanRepository repository;

    public CheckIfBookIsLoanedUseCase(LoanRepository repository) {
        this.repository = repository;
    }

    public boolean execute(int bookId){
        GetActiveLoansUseCase useCase = new GetActiveLoansUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        List<Loan> loanActiveList = useCase.execute();
        for(Loan element : loanActiveList){
            if(element.resource.id == bookId){
                return true;
            }
        }
        return false;
    }
}
