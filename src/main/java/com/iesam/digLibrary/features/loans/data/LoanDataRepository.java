package com.iesam.digLibrary.features.loans.data;

import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.loans.domain.Loan;
import com.iesam.digLibrary.features.loans.domain.LoanRepository;
import com.iesam.digLibrary.features.resources.domain.Resources;

import java.util.ArrayList;
import java.util.List;

public class LoanDataRepository implements LoanRepository {

    private LoanFileLocalDataSource localDataSource;

    public LoanDataRepository(LoanFileLocalDataSource localDataSource) {
        this.localDataSource = localDataSource;
    }

    @Override
    public void saveLoan(Loan loan) {
        localDataSource.save(loan);

    }

    @Override
    public void deleteLoan(int loanId) {
        localDataSource.delete(loanId);
    }

    @Override
    public List<Loan> getActiveLoans() {
        List <Loan>  Loans= localDataSource.findAll();
        List<Loan> activeLoans = new ArrayList<>();
        for(Loan element : Loans){
           if(element.returnDate != null) {
                activeLoans.add(element);
            }
        }
        return activeLoans;
    }

    @Override
    public List<Loan> getFinishedLoans() {
        List <Loan>  Loans= localDataSource.findAll();
        List<Loan> finishedLoans = new ArrayList<>();
        for(Loan element : Loans){
            if(element.returnDate == null) {
                finishedLoans.add(element);
            }
        }
        return finishedLoans;
    }
}
