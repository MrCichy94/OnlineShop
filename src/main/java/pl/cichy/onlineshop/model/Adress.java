package pl.cichy.onlineshop.model;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Adress implements Serializable {

    private static final long serialVersionUID = -530086768384258062L;
    private String doorNo;
    private String streetName;
    private String areaName;
    private String state;
    private String country;
    private String zipCode;

}
