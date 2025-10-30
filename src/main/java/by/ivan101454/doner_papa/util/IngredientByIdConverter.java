package by.ivan101454.doner_papa.util;

import by.ivan101454.doner_papa.data.IngredientRepository;
import by.ivan101454.doner_papa.entities.Ingredient;
import by.ivan101454.doner_papa.entities.Ingredient.Type;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class IngredientByIdConverter implements Converter<String, Ingredient> {

    private final IngredientRepository ingredientRepository;

    @Override
    public Ingredient convert(String id) {
        return ingredientRepository.findById(id).orElse(null);
    }
}
