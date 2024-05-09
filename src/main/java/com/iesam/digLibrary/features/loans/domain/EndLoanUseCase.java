package com.iesam.digLibrary.features.loans.domain;

public class EndLoanUseCase {
    System.out.println("3. Terminar el prestamo");

case 3:
        LoanPresentation.returnResourceToEndLoan();
                System.out.println("Siguiente operación");
                return;

    public void endLoan(Loan loan);

    public class EndLoanUseCase {
        private LoanRepository repository;

        public EndLoanUseCase(LoanRepository repository) {
            this.repository = repository;
        }
        public void execute(Loan loan){
            repository.endLoan(loan);
        }
    }


    public void endLoan(int modelId,Loan model){
        List<Loan> newList = new ArrayList<>();
        List<Loan> models1 = findAll();
        for (Loan element : models1) {
            if (element.loanId != modelId) {
                newList.add(model);
            }
        }
        save(model);
    }

    @Override
    public void endLoan(Loan loan){
        localDataSource.endLoan(loan.loanId, loan);
    }

    public static void returnResourceToEndLoan(){
        System.out.println("Introduce el ID del prestamo cuyo recurso han devuelto: ");
        int unchangedId = sc.nextInt();
        sc.nextLine();
        GetLoanById getLoan = new GetLoanById(new LoanDataRepository(new LoanFileLocalDataSource()));
        Loan selectedLoan = getLoan.execute(unchangedId);

        Loan finishedLoan = new Loan(unchangedId,selectedLoan.resource,selectedLoan.user,selectedLoan.loanDate,"");
        EndLoanUseCase useCase = new EndLoanUseCase(new LoanDataRepository(new LoanFileLocalDataSource()));
        useCase.execute(finishedLoan);
        System.out.println("¡Gracias por devolver el recurso!");

    }

}
