package Supermarket.Service;

import Supermarket.Model.Customer;
import Supermarket.Model.Item;
import Supermarket.Repository.CustomerRepository;
import Supermarket.Repository.ItemRepository;

import java.math.BigDecimal;
import java.util.*;

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

    public void findItem(){
        System.out.print("Digite o código: ");
        sc.nextLine();
        String code = sc.nextLine();

        Optional<Item> item = itemRepository.findOne(code);

        String message = item.isEmpty() ? "Produto não encontrado" : item.get().toString();

        System.out.println(message);
    }

    public void removeItem(){
        System.out.print("Digite o Código: ");
        sc.nextLine();
        String code = sc.nextLine();

        boolean removed = itemRepository.delete(code);

        String message = removed ? "Removido com sucesso!" : "Cliente não encontrado";

        System.out.println(message);
    }

    public boolean updateItem(){
        System.out.print("Digite o código: ");
        sc.nextLine();
        String code = sc.nextLine();

        Optional<Item> item = itemRepository.findOne(code);
        if(item.isEmpty()){
            System.out.println("Cliente não encontrado");
            return updateItem();
        }

        System.out.println(item);

        System.out.print("Digite o novo código ou deixe em branco para manter: ");
        String inputCode = sc.nextLine();

        System.out.print("Digite o novo nome ou deixe em branco para manter: ");
        String name = sc.nextLine();

        System.out.print("Digite o novo preco ou zero para manter: ");
        BigDecimal unitPrice = sc.nextBigDecimal();

        String newCode = inputCode.isEmpty() ? item.get().getCode() : inputCode;
        String newName = name.isEmpty() ? item.get().getName() : name;
        BigDecimal newPrice = unitPrice.compareTo(BigDecimal.ZERO) == 0 ? item.get().getUnitCost() : unitPrice;

        Item itemToUpdate = new Item(newCode, newName, newPrice);
        itemRepository.update(itemToUpdate);
        return true;
    }
}
