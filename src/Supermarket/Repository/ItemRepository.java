package Supermarket.Repository;

import Supermarket.Model.Customer;
import Supermarket.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class ItemRepository implements Repository<Item>{
    private static final List<Item> items = new ArrayList<>();

    @Override
    public Item create(Item object) {
        items.add(object);
        return object;
    }

    @Override
    public List<Item> findAll() {
        return items;
    }

    @Override
    public Optional<Item> findOne(Object id) {
        return items.stream().filter(i -> id.equals(i.getCode())).findFirst();
    }

    @Override
    public Item update(Item object) {
        if(object.getCode().isEmpty()){
            return null;
        }

        int idx = IntStream.range(0, items.size())
                .filter(i -> items.get(i).getCode().equals(object.getCode()))
                .findFirst().orElse(-1);

        if(idx == -1){
            System.out.println("Item not found");
            return null;
        }
        items.set(idx, object);
        return object;
    }

    @Override
    public boolean delete(Object id) {
        return items.removeIf(i -> i.getCode().equals(id));
    }


}
