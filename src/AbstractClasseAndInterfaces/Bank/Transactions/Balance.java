package AbstractClasseAndInterfaces.Bank.Transactions;

public class Balance implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Generating balance");
    }

    @Override
    public void transactionNotOk() {

    }
}
