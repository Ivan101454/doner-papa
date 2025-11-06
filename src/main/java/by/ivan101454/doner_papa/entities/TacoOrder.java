package by.ivan101454.doner_papa.entities;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Table(name = "Taco_Order")
@Entity
public class TacoOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    @Column(name = "placed_at")
    private LocalDate placedAt = LocalDate.now();
    @NotBlank(message = "{customer.order.assemble.errors.name_delivery_is_blank}")
    @Column(name = "delivery_Name")
    private String deliveryName;
    @NotBlank(message = "{customer.order.assemble.errors.street_is_blank}")
    @Column(name = "delivery_Street")
    private String deliveryStreet;
    @NotBlank(message = "{customer.order.assemble.errors.city_is_blank}")
    @Column(name = "delivery_City")
    private String deliveryCity;
    @NotBlank(message = "{customer.order.assemble.errors.state_is_blank}")
    @Column(name = "delivery_State")
    private String deliveryState;
    @NotBlank(message = "{customer.order.assemble.errors.zip_is_blank}")
    @Column(name = "delivery_Zip")
    private String deliveryZip;
    @CreditCardNumber(message = "{customer.order.assemble.errors.credit_card_number_is_not_valid}")
    @Column(name = "cc_number")
    private String ccNumber;
    @Pattern(regexp= "^(0[1-9]|1[0-2])([/])([2-9][0-9])$", message = "{customer.order.assemble.errors.credit_card_date_in_wrong_format}")
    @Column(name = "cc_expiration")
    private String ccExpiration;
    @Digits(integer = 3, fraction = 0, message = "{customer.order.assemble.errors.credit_invalid_cvv}")
    @Column(name = "cc_cvv")
    private String ccCVV;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Taco> tacos = new ArrayList<>();

    public void addTaco(Taco taco) {
        tacos.add(taco);
    }
}
