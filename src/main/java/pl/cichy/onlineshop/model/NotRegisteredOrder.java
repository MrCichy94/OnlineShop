package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;


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
    @NotBlank(message = "Uzupełnij swoje dane: Numer klatki")
    private String placeNo;
    @NotBlank(message = "Uzupełnij swoje dane: Numer mieszkania")
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
    private BigDecimal orderPrice;

    //Constructors
    public NotRegisteredOrder() {
    }

    public NotRegisteredOrder(String name, String lastName, String placeNo, String doorNo, String streetName, String city, String state, String country, String zipCode, BigDecimal orderPrice) {
        this.name = name;
        this.lastName = lastName;
        this.placeNo = placeNo;
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.orderPrice = orderPrice;
    }

    //methods
}
