package AbstractClasseAndInterfaces.Bank;

public class ServicePayment implements Transaction{
    @Override
    public void transactionOk() {
        System.out.println("Paying service...");
    }

    @Override
    public void transactionNotOk() {

    }
}
