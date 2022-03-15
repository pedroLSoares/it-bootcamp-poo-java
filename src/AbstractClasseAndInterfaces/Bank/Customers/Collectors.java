package AbstractClasseAndInterfaces.Bank.Customers;

import AbstractClasseAndInterfaces.Bank.Transactions.Balance;
import AbstractClasseAndInterfaces.Bank.Transactions.Transaction;
import AbstractClasseAndInterfaces.Bank.Transactions.Withdraw;

public class Collectors extends Customer{
    public void consultBalance(){
        Transaction transaction = new Balance();
        transaction.transactionOk();
    }

    public void withdrawMoney(){
        Transaction transaction = new Withdraw();
        transaction.transactionOk();
    }

}
