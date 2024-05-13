package com.iesam.digLibrary.features.loans.domain;

import com.iesam.digLibrary.features.resources.domain.Resources;
import com.iesam.digLibrary.features.user.domain.User;

import java.util.Calendar;
import java.util.Date;

public class Loan {
    public final int loanId;
    public final Resources resource;

    public final User user;
    public final Date loanDate; // Cuando se presta.
    public final Date expectedDate; // Cuando se supone que se tiene que devolver.
    public final Date returnedDate; //Nullable. Cuando el usuario devuelve el recurso

    public Loan(int loanId, Resources resource, User user, Date loanDate, Date expectedDate, Date returnedDate) {
        this.loanId = loanId;
        this.resource = resource;
        this.user = user;
        this.loanDate = loanDate;
        this.expectedDate = expectedDate;
        this.returnedDate = returnedDate;
    }

    public boolean isActive() {
        return returnedDate == null;
    }
    public static Date calculateExpectedDate(Date loanDate) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(loanDate);
        calendar.add(Calendar.MONTH, 1); // Adding one month
        return calendar.getTime();
    }


}
