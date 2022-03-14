package AbstractClasseAndInterfaces.Bank;

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
