package by.ivan101454.doner_papa.util;

import by.ivan101454.doner_papa.data.IngredientRepository;
import by.ivan101454.doner_papa.entities.Ingredient;
import by.ivan101454.doner_papa.entities.Ingredient.Type;
import by.ivan101454.doner_papa.entities.IngredientUDT;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, IngredientUDT> {

    private final IngredientRepository ingredientRepository;

    @Override
    public IngredientUDT convert(String id) {
        return ingredientRepository.findById(id).map(TacoUDRUtils::toIngredientUDT).orElse(null);
    }
}
