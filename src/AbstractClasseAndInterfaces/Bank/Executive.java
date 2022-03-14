package AbstractClasseAndInterfaces.Bank;

public class Executive extends Customer{
    public void deposit(){
        Deposit deposit = new Deposit();
        deposit.transactionOk();
    }

    public void transfer(){
        Transaction transaction = new Transferency();
        transaction.transactionOk();
    }
}
