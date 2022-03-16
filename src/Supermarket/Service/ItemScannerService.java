package Supermarket.Service;

import Supermarket.Model.Item;
import Supermarket.Repository.CustomerRepository;
import Supermarket.Repository.ItemRepository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Scanner;

public class ItemScannerService {

    private final ItemRepository itemRepository = new ItemRepository();
    private final Scanner sc;

    public ItemScannerService(Scanner sc) {
        this.sc = sc;
    }

    public void listAllItems(){
        List<Item> items = itemRepository.findAll();
        items.forEach(i -> System.out.println(i.getCode() + " - " + i.getName() + " R$ " + i.getUnitCost()));
    }

    public void createItem(){
        System.out.print("Digite o Código: ");
        sc.nextLine();
        String code = sc.nextLine();

        System.out.print("Digite o Nome: ");

        String name = sc.nextLine();

        System.out.print("Digite o custo unitário: ");
        BigDecimal unitPrice = sc.nextBigDecimal();

        itemRepository.create(new Item(code,name, unitPrice));

        System.out.println("Produto cadastrado");

    }
}
