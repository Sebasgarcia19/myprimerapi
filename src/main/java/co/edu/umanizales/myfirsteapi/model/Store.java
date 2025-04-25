package co.edu.umanizales.myfirsteapi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Store {
    private Location location;
    private String name;
    private String adress;
    private String code;
    private String id;
}
