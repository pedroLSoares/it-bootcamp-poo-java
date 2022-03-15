package AbstractClasseAndInterfaces.Bank.Customers;

import AbstractClasseAndInterfaces.Bank.Transactions.Deposit;
import AbstractClasseAndInterfaces.Bank.Transactions.Transaction;
import AbstractClasseAndInterfaces.Bank.Transactions.Transferency;

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
