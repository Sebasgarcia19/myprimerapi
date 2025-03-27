package co.edu.umanizales.myfirsteapi.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Seller {
    private String name;
    private String lastname;
    private byte age;
    private String gander;
    private String identification;
    private String location;


}
