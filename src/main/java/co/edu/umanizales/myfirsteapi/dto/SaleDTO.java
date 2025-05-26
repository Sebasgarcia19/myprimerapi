package co.edu.umanizales.myfirsteapi.dto;

import co.edu.umanizales.myfirsteapi.model.ProductSale;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
@Data
public class SaleDTO {
    private String seller;
    private String store;
    private List<ProductSale> products;
    private LocalDate saleDate;

}
