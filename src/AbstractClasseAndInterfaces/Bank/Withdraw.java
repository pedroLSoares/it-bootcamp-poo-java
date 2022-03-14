package AbstractClasseAndInterfaces.Bank;

public class Withdraw implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Withdraw money...");
    }

    @Override
    public void transactionNotOk() {

    }
}
