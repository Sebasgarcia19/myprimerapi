package co.edu.umanizales.myfirsteapi.dto;

import lombok.Data;

@Data
public class ProductDTO {
    private String code;
    private String description;
    private double price;
    private int stock;
    private String codeTypeProduct;
}
