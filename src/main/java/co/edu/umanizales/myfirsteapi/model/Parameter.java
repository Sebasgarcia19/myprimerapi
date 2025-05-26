package co.edu.umanizales.myfirsteapi.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
@AllArgsConstructor
public abstract class Parameter {
    private String code;
    private String description;
}
