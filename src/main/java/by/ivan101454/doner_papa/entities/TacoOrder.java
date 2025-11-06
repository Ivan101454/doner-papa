package by.ivan101454.doner_papa.entities;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@Table(value = "orders")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @PrimaryKey
    @Column(value = "id")
    private UUID id = Uuids.timeBased();
    @Column(value = "placed_at")
    private LocalDate placedAt = LocalDate.now();
    @NotBlank(message = "{customer.order.assemble.errors.name_delivery_is_blank}")
    @Column(value = "delivery_Name")
    private String deliveryName;
    @NotBlank(message = "{customer.order.assemble.errors.street_is_blank}")
    @Column(value = "delivery_Street")
    private String deliveryStreet;
    @NotBlank(message = "{customer.order.assemble.errors.city_is_blank}")
    @Column(value = "delivery_City")
    private String deliveryCity;
    @NotBlank(message = "{customer.order.assemble.errors.state_is_blank}")
    @Column(value = "delivery_State")
    private String deliveryState;
    @NotBlank(message = "{customer.order.assemble.errors.zip_is_blank}")
    @Column(value = "delivery_Zip")
    private String deliveryZip;
    @CreditCardNumber(message = "{customer.order.assemble.errors.credit_card_number_is_not_valid}")
    @Column(value = "cc_number")
    private String ccNumber;
    @Pattern(regexp= "^(0[1-9]|1[0-2])([/])([2-9][0-9])$", message = "{customer.order.assemble.errors.credit_card_date_in_wrong_format}")
    @Column(value = "cc_expiration")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "{customer.order.assemble.errors.credit_invalid_cvv}")
    @Column(value = "cc_cvv")
    private String ccCVV;

    @Column(value = "tacos")
    private List<TacoUDT> tacos = new ArrayList<>();

    public void addTaco(TacoUDT taco) {
        tacos.add(taco);
    }
}
