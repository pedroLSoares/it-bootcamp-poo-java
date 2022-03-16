package Supermarket.Repository;

import Supermarket.Model.Invoice;
import Supermarket.Model.Item;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class InvoiceRepository implements Repository<Invoice> {
    private static final List<Invoice> invoices = new ArrayList<>();

    @Override
    public Invoice create(Invoice object) {
        object.setID(invoices.size() + 1);
        invoices.add(object);
        return object;
    }

    @Override
    public List<Invoice> findAll() {
        return invoices;
    }

    @Override
    public Optional<Invoice> findOne(Object id) {
        return invoices.stream().filter(c -> id.equals(c.getID())).findFirst();
    }

    @Override
    public Invoice update(Invoice object) {
        if(object.getID() == 0 || invoices.get(object.getID() - 1) == null){
            return null;
        }

        invoices.set(object.getID() - 1, object);
        return object;
    }

    @Override
    public boolean delete(Object id) {
        return invoices.removeIf(c -> id.equals(c.getID()));
    }
}
