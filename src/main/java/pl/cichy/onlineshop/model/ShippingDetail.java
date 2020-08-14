package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
public class ShippingDetail implements Serializable {

    private static final long serialVersionUID = 6350930334140807514L;
    private String name;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private Date shippingDate;
    private Adress shippingAdress;

    public ShippingDetail() {
        this.shippingAdress = new Adress();
    }
}
