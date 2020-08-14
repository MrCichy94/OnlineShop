package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Map;

@Getter
@Setter
public class NoRegistryOrder {

    //Customer
    private String name;
    private String lastName;
    private String address;

    //Adress
    private String doorNo;
    private String streetName;
    private String city;
    private String state;
    private String country;
    private String zipCode;

    //CartItems - with special cartId!
    private String cartId;
    private Map<String, CartItem> cartItems;
    private BigDecimal grandTotal;

    //Constructors
    public NoRegistryOrder() {
    }

    public NoRegistryOrder(String name, String address, String doorNo, String streetName, String city, String state, String country, String zipCode, String cartId, Map<String, CartItem> cartItems, BigDecimal grandTotal) {
        this.name = name;
        this.address = address;
        this.doorNo = doorNo;
        this.streetName = streetName;
        this.city = city;
        this.state = state;
        this.country = country;
        this.zipCode = zipCode;
        this.cartId = cartId;
        this.cartItems = cartItems;
        this.grandTotal = grandTotal;
    }

    //methods
}
