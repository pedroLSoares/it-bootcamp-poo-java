package Supermarket.Repository;

import java.util.List;
import java.util.Optional;

public interface Repository<T> {
    public T create(T object);

    public List<T> findAll();

    public Optional<T> findOne(Object id);

    public T update(T object);

    public boolean delete(Object id);

}
