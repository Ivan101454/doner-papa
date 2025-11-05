package by.ivan101454.doner_papa.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Table("Taco_Order")
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column("id")
    private Long id;
    @Column("placed_at")
    private LocalDate placedAt;
    @NotBlank(message = "{customer.order.assemble.errors.name_delivery_is_blank}")
    @Column("delivery_Name")
    private String deliveryName;
    @NotBlank(message = "{customer.order.assemble.errors.street_is_blank}")
    @Column("delivery_Street")
    private String deliveryStreet;
    @NotBlank(message = "{customer.order.assemble.errors.city_is_blank}")
    @Column("delivery_City")
    private String deliveryCity;
    @NotBlank(message = "{customer.order.assemble.errors.state_is_blank}")
    @Column("delivery_State")
    private String deliveryState;
    @NotBlank(message = "{customer.order.assemble.errors.zip_is_blank}")
    @Column("delivery_Zip")
    private String deliveryZip;
    @CreditCardNumber(message = "{customer.order.assemble.errors.credit_card_number_is_not_valid}")
    @Column("cc_number")
    private String ccNumber;
    @Pattern(regexp= "^(0[1-9]|1[0-2])([/])([2-9][0-9])$", message = "{customer.order.assemble.errors.credit_card_date_in_wrong_format}")
    @Column("cc_expiration")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "{customer.order.assemble.errors.credit_invalid_cvv}")
    @Column("cc_cvv")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
