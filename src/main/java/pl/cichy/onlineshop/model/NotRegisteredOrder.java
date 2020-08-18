package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
@Entity
@Table( name = "not_registered_orders")
public class NotRegisteredOrder {

    //noRegistryOrder
    @Id
    @GeneratedValue(generator = "inc")
    @GenericGenerator(name = "inc", strategy = "increment")
    private int id;

    //Customer
    @NotBlank(message = "Uzupełnij swoje dane: Imię")
    private String name;
    @NotBlank(message = "Uzupełnij swoje dane: Nazwisko")
    private String lastName;

    //Adress
    @NotBlank(message = "Uzupełnij swoje dane: Numer lokalu")
    private String placeNo;
    @NotBlank(message = "Uzupełnij swoje dane: Numer drzwi")
    private String doorNo;
    @NotBlank(message = "Uzupełnij swoje dane: Ulica")
    private String streetName;
    @NotBlank(message = "Uzupełnij swoje dane: Miasto")
    private String city;
    @NotBlank(message = "Uzupełnij swoje dane: Województwo")
    private String state;
    @NotBlank(message = "Uzupełnij swoje dane: Kraj")
    private String country;
    @NotBlank(message = "Uzupełnij swoje dane: Kod pocztowy")
    private String zipCode;

    //Cart
    private Cart cart;

    //Constructors
    public NotRegisteredOrder() {
    }

    public NotRegisteredOrder(String name, String lastName, String placeNo, String doorNo, String streetName, String city, String state, String country, String zipCode, Cart cart) {
        this.name = name;
        this.lastName = lastName;
        this.placeNo = placeNo;
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.cart = cart;
    }

    //methods
}
