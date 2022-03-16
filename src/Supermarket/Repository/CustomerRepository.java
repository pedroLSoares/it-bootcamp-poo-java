package Supermarket.Repository;

import Supermarket.Model.Customer;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CustomerRepository implements Repository<Customer>{
    private static final List<Customer> customers = new ArrayList<>();

    @Override
    public Customer create(Customer object) {
        object.setID(customers.size() + 1);
        customers.add(object);
        return object;
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Optional<Customer> findOne(Object id) {
        return customers.stream().filter(c -> id.equals(c.getID())).findFirst();
    }

    @Override
    public Customer update(Customer object) {
        if(object.getID() == 0 || customers.get(object.getID() - 1) == null){
            return null;
        }

        customers.set(object.getID() - 1, object);
        return object;
    }

    @Override
    public boolean delete(Object id) {
        return customers.removeIf(c -> id.equals(c.getID()));
    }
}
