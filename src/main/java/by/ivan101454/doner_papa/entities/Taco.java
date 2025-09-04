package by.ivan101454.doner_papa.entities;

import lombok.Data;

import java.util.List;

@Data
public class Taco {

    private String name;
    private List<Ingredient> ingredients;
}
