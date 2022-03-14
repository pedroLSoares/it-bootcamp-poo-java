package AbstractClasseAndInterfaces.Bank;

public class Basic extends Customer{

    public void consultBalance(){
        Transaction transaction = new Balance();
        transaction.transactionOk();
    }

    public void withdrawMoney(){
        Transaction transaction = new Withdraw();
        transaction.transactionOk();
    }

    public void payService(){
        Transaction transaction = new ServicePayment();
        transaction.transactionOk();
    }
}
