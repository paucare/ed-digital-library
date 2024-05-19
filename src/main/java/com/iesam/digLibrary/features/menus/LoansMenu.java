package com.iesam.digLibrary.features.menus;

import com.iesam.digLibrary.features.loans.presentation.LoanPresentation;

public class LoansMenu implements Menu{
    public final MenuSystem menuSystem;

    public LoansMenu(MenuSystem menuSystem) {
        this.menuSystem = menuSystem;
    }

    @Override
    public void display() {
        ConsoleUtils.clearConsole();
        System.out.println("P. Loan management .P");
        System.out.println("0. Return to main menu");
        System.out.println("1. Register a loan");
        System.out.println("2. Delete a loan");
        System.out.println("3. End a loan");
        System.out.println("4. Show active loans");
        System.out.println("5. Show finished loans");
        System.out.println("6. Check if a resource is loaned");
        System.out.print("Enter an option: ");
    }

    @Override
    public void processChoice(int choice) {
        switch (choice) {
            case 0:
                System.out.println("Returning to the main menu...");
                menuSystem.goBack();
                break;
            case 1:
                LoanPresentation.showLoanForm();
                System.out.println("Next operation");
                return;
            case 2:
                LoanPresentation.deleteLoan();
                System.out.println("Next operation");
                return;
            case 3:
                LoanPresentation.returnResourceToEndLoan();
                System.out.println("Next operation");
                return;
            case 4:
                LoanPresentation.getActiveLoans();
                System.out.println("Next operation");
                return;
            case 5:
                LoanPresentation.getFinishedLoans();
                System.out.println("Next operation");
                return;
            case 6:
                LoanPresentation.checkIfResourceIsLoaned();
                System.out.println("Next operation");
                return;
            default:
                System.out.println("Option not valid. Try again.");
                break;
        }
    }
}
