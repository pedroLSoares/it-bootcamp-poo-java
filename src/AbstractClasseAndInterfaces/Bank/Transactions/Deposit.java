package AbstractClasseAndInterfaces.Bank.Transactions;

public class Deposit implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Making deposit");
    }

    @Override
    public void transactionNotOk() {

    }
}
