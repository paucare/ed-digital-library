package com.iesam.digLibrary.features.loans.domain;

import java.util.List;

public interface LoanRepository {
    public void saveLoan(Loan loan);
    public void deleteLoan(int loanId);
    public void endLoan(Loan loan);
    public Loan getLoanById(int id);
    public List<Loan> getActiveLoans();
    public List<Loan> getFinishedLoans();
}
