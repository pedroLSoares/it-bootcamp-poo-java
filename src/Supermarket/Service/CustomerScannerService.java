package Supermarket.Service;

import Supermarket.Model.Customer;
import Supermarket.Repository.CustomerRepository;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class CustomerScannerService {
    private final CustomerRepository customerRepository = new CustomerRepository();
    private final Scanner sc;

    public CustomerScannerService(Scanner sc) {
        this.sc = sc;
    }

    public void findCustomer(){
        System.out.print("Digite o ID: ");

        int id = sc.nextInt();

        Optional<Customer> customer = customerRepository.findOne(id);

        String message = customer.isEmpty() ? "Usuário não encontrado" : customer.get().toString();

        System.out.println(message);
    }

    public void createCustomer(){
        System.out.print("Digite o Nome: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Digite o Sobrenome: ");
        sc.nextLine();
        String lastName = sc.nextLine();

        customerRepository.create(new Customer(name, lastName));

        System.out.println("Cliente cadastrado com sucesso");

    }

    public void removeCustomer(){
        System.out.print("Digite o ID: ");

        int id = sc.nextInt();

        boolean removed = customerRepository.delete(id);

        String message = removed ? "Removido com sucesso!" : "Cliente não encontrado";

        System.out.println(message);
    }

    public boolean updateCustomer(){
        System.out.print("Digite o ID: ");

        int id = sc.nextInt();

        Optional<Customer> customer = customerRepository.findOne(id);
        if(customer.isEmpty()){
            System.out.println("Cliente não encontrado");
            return updateCustomer();
        }

        System.out.println(customer);


        System.out.print("Digite o novo nome ou deixe em branco para manter: ");
        sc.nextLine();
        String name = sc.nextLine();

        System.out.print("Digite o novo Sobrenome ou deixe em branco para manter: ");
        sc.nextLine();
        String lastName = sc.nextLine();

        String newName = name.isEmpty() ? customer.get().getName() : name;
        String newLastName = lastName.isEmpty() ? customer.get().getLastName() : lastName;

        Customer customerToUpdate = new Customer(customer.get().getID(), newName, newLastName);
        customerRepository.update(customerToUpdate);
        return true;

    }

    public void listAllCustomer(){
        List<Customer> customers = customerRepository.findAll();
        customers.forEach((c) -> System.out.println(c.getID() + " - " + c.getName()));
    }
}
