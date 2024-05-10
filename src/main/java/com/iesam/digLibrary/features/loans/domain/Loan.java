package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;

public class Loan {
    public final int loanId;
    public final Resources resource;

    public final User user;
    public final String loanDate; // Cuando se presta.
    public final String expectedDate; // Cuando se supone que se tiene que devolver.
    public final String returnedDate; //Nullable. Cuando el usuario devuelve el recurso

    public Loan(int loanId, Resources resource, User user, String loanDate, String expectedDate, String returnedDate) {
        this.loanId = loanId;
        this.resource = resource;
        this.user = user;
        this.loanDate = loanDate;
        this.expectedDate = expectedDate;
        this.returnedDate = returnedDate;
    }


    /*public boolean isActive() {
        Date currentDate = new Date();
        return returnDate == null || returnDate.compareTo(currentDate) > 0 ;
    }*/

    public boolean isActive() {
        return returnedDate == null;
    }

}
