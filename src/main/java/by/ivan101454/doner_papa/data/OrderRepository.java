package by.ivan101454.doner_papa.data;

import by.ivan101454.doner_papa.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<TacoOrder, Integer> {
}
