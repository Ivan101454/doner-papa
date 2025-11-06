package by.ivan101454.doner_papa.util;

import by.ivan101454.doner_papa.entities.Ingredient;
import by.ivan101454.doner_papa.entities.IngredientUDT;
import by.ivan101454.doner_papa.entities.Taco;
import by.ivan101454.doner_papa.entities.TacoUDT;

import java.util.List;
import java.util.stream.Collectors;

public class TacoUDRUtils {

    public static TacoUDT toTacoUDT(Taco taco) {
        return new TacoUDT(taco.getName(), taco.getIngredients());
    }

    public static List<IngredientUDT> toIngredientUDTs(List<Ingredient> ingredients) {
        return ingredients.stream()
                .map(TacoUDRUtils::toIngredientUDT)
                .collect(Collectors.toList());
    }

    public static IngredientUDT toIngredientUDT(Ingredient ingredient) {
        return new IngredientUDT(ingredient.getName(), ingredient.getType());
    }

}