package co.edu.umanizales.myfirsteapi.controller;

import co.edu.umanizales.myfirsteapi.model.Seller;
import co.edu.umanizales.myfirsteapi.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/seller")

public class SellerController {

    @Autowired
    private SellerService sellerService;

    @GetMapping
    public List<Seller> getSellers() {
        return sellerService.getSellers();
    }

    @GetMapping(path = "/{identification}")
    public Seller getSellerByIdentification(@PathVariable String identification) {
        return sellerService.getSellerByIdentification(identification);
    }
}