package by.ivan101454.doner_papa.data;

import by.ivan101454.doner_papa.entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository extends CrudRepository<Ingredient, String> {
}
