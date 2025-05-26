package co.edu.umanizales.myfirsteapi.service;

import co.edu.umanizales.myfirsteapi.model.Sale;
import lombok.Getter;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class SaleService {

    // Lista de ventas
    private List<Sale> sales = new ArrayList<>();

    // Filtrar ventas por código de tienda
    public List<Sale> filterByStore(String code) {
        List<Sale> filteredSales = new ArrayList<>();
        for (Sale sale : sales) {
            if (sale.getStore().getCode().equals(code)) {
                filteredSales.add(sale);
            }
        }
        return filteredSales;
    }

    // Filtrar ventas por identificación del vendedor
    public List<Sale> filterBySeller(String id) {
        List<Sale> filteredSales = new ArrayList<>();
        for (Sale sale : sales) {
            if (sale.getSeller().getIdentification().equals(id)) {
                filteredSales.add(sale);
            }
        }
        return filteredSales;
    }
}