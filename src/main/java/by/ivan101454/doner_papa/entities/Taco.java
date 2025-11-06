package by.ivan101454.doner_papa.entities;

import by.ivan101454.doner_papa.util.TacoUDRUtils;
import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@Table(value = "taco")
public class Taco {

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED)
    private UUID id = Uuids.timeBased();

    @NotNull(message = "{customer.order.assemble.errors.name_is_null}")
    @Size(min = 5, message = "{customer.order.assemble.errors.name_is_less_five}")
    @Column(value = "name")
    private String name;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,
    ordering = Ordering.DESCENDING)
    @Column(value = "created_at")
    private LocalDate createAt = LocalDate.now();

    @NotNull(message = "{customer.order.assemble.errors.list_is_null}")
    @Size(min = 1, message = "{customer.order.assemble.errors.number_of_ingredients_less_one}")
    @Column(value = "ingredients")
    private List<IngredientUDT> ingredients;

    public void addIngredient(Ingredient ingredient) {
        ingredients.add(TacoUDRUtils.toIngredientUDT(ingredient));
    }
}
