package Supermarket.Service;

import Supermarket.Model.Customer;
import Supermarket.Model.Invoice;
import Supermarket.Model.Item;
import Supermarket.Repository.CustomerRepository;
import Supermarket.Repository.ItemRepository;

import java.lang.reflect.Method;
import java.util.*;
import java.util.stream.Collectors;

public class TerminalMarketService {

    private CustomerScannerService customerScannerService;
    private Scanner sc;

    public TerminalMarketService() {
        CustomerRepository customerRepository = new CustomerRepository();
        customerRepository.create(new Customer( "Pedro", "Soares"));
        customerRepository.create(new Customer( "Joao", "Silva"));
        customerRepository.create(new Customer( "Mario", "Andrade"));
    }

    public void run(){
        this.sc = new Scanner(System.in);
        this.customerScannerService = new CustomerScannerService(this.sc);
        showMenu();

    }

    private void showMenu(){
        try {
            String[] options = {"invoiceOptions", "customerOptions", "itemsOptions"};
            System.out.println("Selecione uma das opcoes: ");

            System.out.println("1 - Faturas");
            System.out.println("2 - Clientes");
            System.out.println("3 - Items");

            int selectedOption = sc.nextInt();

            Method method = TerminalMarketService.class.getDeclaredMethod(options[selectedOption - 1]);

            method.invoke(this);
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    private void itemsOptions(){
        try {
            String[] options = {"findItem", "createItem", "removeItem", "updateItem"};
            executeOptions(options, new ItemScannerService(sc));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void invoiceOptions(){
        try {
            String[] options = {"findInvoice", "createInvoice"};
            executeOptions(options, new InvoiceScannerService(sc));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void customerOptions(){
        try {
            String[] options = {"findCustomer", "createCustomer", "removeCustomer", "updateCustomer", "showMenu"};
            executeOptions(options, customerScannerService);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private int getSelectedOption() {
        System.out.println("Selecione uma das opcoes: ");
        System.out.println("1 - Consultar");
        System.out.println("2 - Incluir");
        System.out.println("3 - Remover");
        System.out.println("4 - Editar");
        System.out.println("5 - Voltar");

        return sc.nextInt();
    }

    private void executeOptions(String[] options, Object cl){
        try{


            int selectedOption = getSelectedOption();

            if(selectedOption == 5){
                showMenu();
                return;
            }

            if(selectedOption > options.length || selectedOption <= 0) {
                try {
                    System.out.println("Opcao inválida");


                    Method method = TerminalMarketService.class.getDeclaredMethod(Thread.currentThread().getStackTrace()[2].getMethodName());

                    method.invoke(this);
                } catch (Exception e) {
                    e.printStackTrace();
                }


            }

            Method method = cl.getClass().getDeclaredMethod(options[selectedOption - 1]);

            method.invoke(cl);

            method = TerminalMarketService.class.getDeclaredMethod(Thread.currentThread().getStackTrace()[2].getMethodName());

            method.invoke(this);

        }catch (Exception e){
            e.printStackTrace();
        }



    }
}
