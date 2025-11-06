package by.ivan101454.doner_papa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Table(name = "Taco")
@Entity
public class Taco {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "created_at")
    private LocalDate createAt = LocalDate.now();

    @NotNull(message = "{customer.order.assemble.errors.name_is_null}")
    @Size(min = 5, message = "{customer.order.assemble.errors.name_is_less_five}")
    @Column(name = "name")
    private String name;

    @NotNull(message = "{customer.order.assemble.errors.list_is_null}")
    @Size(min = 1, message = "{customer.order.assemble.errors.number_of_ingredients_less_one}")
    @ManyToMany
    private List<Ingredient> ingredients;
}
