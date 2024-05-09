package com.iesam.digLibrary.features.loans.data;

import com.iesam.digLibrary.features.loans.data.local.LoanFileLocalDataSource;
import com.iesam.digLibrary.features.loans.domain.Loan;
import com.iesam.digLibrary.features.loans.domain.LoanRepository;

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
    public Loan getLoanById(int id){
        return localDataSource.findById(id);
    }

    @Override
    public void deleteLoan(int loanId) {
        localDataSource.delete(loanId);
    }
    @Override
    public void endLoan(Loan loan){
        localDataSource.endLoan(loan.loanId, loan);
    }

    @Override
    public List<Loan> getLoans() {
        return localDataSource.findAll();
    }

    /*
    @Override
    public List<Loan> getActiveLoans() {
        return localDataSource.getActiveLoans();
    }

    @Override
    public List<Loan> getFinishedLoans() {
       return localDataSource.getFinishedLoans();
    }

     */
}
