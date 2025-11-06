package by.ivan101454.doner_papa.data;

import by.ivan101454.doner_papa.entities.TacoOrder;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface OrderRepository extends CrudRepository<TacoOrder, UUID> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);
}
