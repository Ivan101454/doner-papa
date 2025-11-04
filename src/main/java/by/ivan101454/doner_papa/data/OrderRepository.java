package by.ivan101454.doner_papa.data;

import by.ivan101454.doner_papa.entities.TacoOrder;

public interface OrderRepository {

    TacoOrder save(TacoOrder order);
}
