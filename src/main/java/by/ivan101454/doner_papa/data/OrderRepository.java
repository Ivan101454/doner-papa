package by.ivan101454.doner_papa.data;

import by.ivan101454.doner_papa.entities.TacoOrder;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Integer> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    @Query(value = "SELECT * FROM Taco_Order o WHERE deliveryCity = :city", nativeQuery = true)
    List<TacoOrder> readOrdersWhereDeliveredInMinsk(@Param("city") String deliveryCity);
}
