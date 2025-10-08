package by.ivan101454.doner_papa.entities;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.List;

@Data
public class Taco {

    @NotNull(message = "{customer.order.assemble.errors.name_is_null}")
    @Size(min = 5, message = "{customer.order.assemble.errors.name_is_less_five}")
    private String name;

    @NotNull(message = "{customer.order.assemble.errors.list_is_null}")
    @Size(min = 1, message = "{customer.order.assemble.errors.number_of_ingredients_less_one}")
    private List<Ingredient> ingredients;
}
