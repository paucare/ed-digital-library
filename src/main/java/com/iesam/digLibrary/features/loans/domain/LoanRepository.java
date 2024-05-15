package com.iesam.digLibrary.features.loans.domain;

import java.util.List;

public interface LoanRepository {
    public void saveLoan(Loan loan);
    public void deleteLoan(long loanId);
    public Loan getLoanById(long id);
    public List<Loan> getLoans();

}
