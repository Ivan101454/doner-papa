package by.ivan101454.doner_papa.entities;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

import java.util.List;

@Getter
@Setter
@RequiredArgsConstructor
@UserDefinedType(value = "taco")
public class TacoUDT {

    private final String name;
    private final List<IngredientUDT> ingredients;
}
