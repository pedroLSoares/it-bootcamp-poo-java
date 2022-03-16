package Supermarket.Service;

import Supermarket.Model.Customer;
import Supermarket.Model.Invoice;
import Supermarket.Model.Item;
import Supermarket.Repository.CustomerRepository;
import Supermarket.Repository.InvoiceRepository;
import Supermarket.Repository.ItemRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class InvoiceScannerService {
    private final InvoiceRepository invoiceRepository = new InvoiceRepository();
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final ItemRepository itemRepository = new ItemRepository();
    private final CustomerScannerService customerScannerService;
    private final ItemScannerService itemScannerService;
    private final Scanner sc;

    public InvoiceScannerService(Scanner sc) {
        this.sc = sc;
        this.customerScannerService = new CustomerScannerService(sc);
        this.itemScannerService = new ItemScannerService(sc);
    }

    public void findInvoice(){
        System.out.print("Digite o ID da fatura: ");

        int invoiceId = sc.nextInt();

        List<Invoice> invoices = invoiceRepository.findAll();

        Optional<Invoice> invoice =  invoices.stream().filter(c -> c.getID() == invoiceId).findFirst();

        if(invoice.isEmpty()){
            System.out.println("Fatura não encontrada");
            return;
        }

        System.out.println(invoice.get());
    }

    public void createInvoice(){
        try {


            customerScannerService.listAllCustomer();
            System.out.print("Digite o nome do cliente: ");
            sc.nextLine();
            String name = sc.nextLine();

            System.out.print("Digite o sobrenome do cliente: ");
            String lastName = sc.nextLine();

            List<Customer> customers = customerRepository.findAll();

            Optional<Customer> optionalCustomer = customers.stream().filter(c -> c.getName().equals(name) && c.getLastName().equals(lastName)).findFirst();

            Customer customer = optionalCustomer.isEmpty() ? new Customer(customers.size() + 1, name, lastName) : optionalCustomer.get();

            if (optionalCustomer.isEmpty()) {
                System.out.println("Cliente " + name + " " + lastName + " não foi encontrado, portanto foi realizado um cadastro.");
            }

            System.out.println("Selecione os itens: ");
            System.out.println("Digite 0 para encerrar a selecão");
            itemScannerService.listAllItems();
            List<Item> products = new ArrayList<>();

            while (true) {
                int finish = sc.hasNextInt() ? sc.nextInt() : 1;
                if (finish == 0) {
                    break;
                }

                String code = sc.nextLine();

                List<Item> items = itemRepository.findAll();
                Optional<Item> item = items.stream().filter(i -> i.getCode().equals(code)).findFirst();

                if (item.isEmpty()) {
                    System.out.println("Produto não cadastrado");
                    continue;
                }

                System.out.print("Informe a quantidade: ");
                int qty = sc.nextInt();

                item.get().setQtyBought(qty);

                products.add(item.get());

                System.out.println("Produto adicionado.");

            }

            invoiceRepository.create(new Invoice(customer, products));

            System.out.println("Fatura criada com sucesso");

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
