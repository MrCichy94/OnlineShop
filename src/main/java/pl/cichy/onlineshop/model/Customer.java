package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Customer implements Serializable {

    private String name;
    private String address;
    private long noOfOrdersMade;
    private String customerId;
    private static final long serialVersionUID = 2284040482222162898L;
    private Address billingAddress;
    private String phoneNumber;

    public Customer() {
        super();
        this.billingAddress = new Address();
    }
    public Customer(String customerId, String name) {
        this();
        this.customerId = customerId;
        this.name = name;
    }

    public Customer(String name, String address, long noOfOrdersMade, String customerId) {
        super();
        this.name = name;
        this.address = address;
        this.noOfOrdersMade = noOfOrdersMade;
        this.customerId = customerId;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (customerId == null) {
            if (other.customerId != null)
                return false;
        } else if (!customerId.equals(other.customerId))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((customerId == null) ? 0 :customerId.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Produkt [productId=" + customerId + ", nazwa=" + name +"]";
    }


}
