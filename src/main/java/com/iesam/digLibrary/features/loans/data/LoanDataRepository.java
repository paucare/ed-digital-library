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
    public Loan getLoanById(long id){
        return localDataSource.findById(id);
    }

    @Override
    public void deleteLoan(long loanId) {
        localDataSource.delete(loanId);
    }

    @Override
    public List<Loan> getLoans() {
        return localDataSource.findAll();
    }
}
