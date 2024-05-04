package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;

import java.time.LocalDate;

public class Loan {
    public final int loanId;
    public final Resources resource;
    public final User user;
    public final LocalDate loanDate;
    public final LocalDate returnDate; //Nullable

    public Loan(int loanId, Resources resource, User user, LocalDate loanDate, LocalDate returnDate) {
        this.loanId = loanId;
        this.resource = resource;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    public boolean isActive() {
        return returnDate == null || returnDate.isAfter(LocalDate.now());
    }

}
