package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;

import java.util.Date;

public class Loan {
    public final int loanId;
    public final Resources resource;

    public final User user;
    public final String loanDate;
    public final String returnDate; //Nullable


    public Loan(int loanId, Resources resource, User user, String loanDate, String returnDate) {
        this.loanId = loanId;
        this.resource = resource;
        this.user = user;
        this.loanDate = loanDate;
        this.returnDate = returnDate;
    }

    /*public boolean isActive() {
        Date currentDate = new Date();
        return returnDate == null || returnDate.compareTo(currentDate) > 0 ;
    }*/

    public boolean isActive() {
        Date currentDate = new Date();
        return returnDate != null;
    }

}
