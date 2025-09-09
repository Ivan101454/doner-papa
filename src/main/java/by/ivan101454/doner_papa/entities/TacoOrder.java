package by.ivan101454.doner_papa.entities;

import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.util.ArrayList;
import java.util.List;

@Data
public class TacoOrder {

    @NotBlank(message = "customer.order.assemble.errors.name_delivery_is_blank")
    private String deliveryName;
    @NotBlank(message = "customer.order.assemble.errors.street_is_blank")
    private String deliveryStreet;
    @NotBlank(message = "customer.order.assemble.errors.city_is_blank")
    private String deliveryCity;
    @NotBlank(message = "customer.order.assemble.errors.state_is_blank")
    private String deliveryState;
    @NotBlank(message = "customer.order.assemble.errors.zip_is_blank")
    private String deliveryZip;
    @CreditCardNumber(message = "customer.order.assemble.errors.credit_card_number_is_not_valid")
    private String ccNumber;
    @Pattern(regexp= "^(0[1-9]|1[0-2])([/])([2-9][0-9])$", message = "customer.order.assemble.errors.credit_card_date_in_wrong_format")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "customer.order.assemble.errors.credit_invalid_cvv")
    private String ccCVV;

    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
