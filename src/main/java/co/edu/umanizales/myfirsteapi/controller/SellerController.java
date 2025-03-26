package co.edu.umanizales.myfirsteapi.controller;

import co.edu.umanizales.myfirsteapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/Seller")
public class SellerController {
    @GetMapping
    String getSeller(){
        Seller sebas = new Seller("sebas","Garcia", "26" , "H" ,"1053866543" , "Manizales");
        Seller camilo = new Seller("camilo","lopez", "18" , "H" ,"1053863309" , "Pereira");
        Seller pedro = new Seller("pedro","hincapie", "45" , "H" ,"1053855423" , "Manizales");
        Seller camila = new Seller("camila","flores", "28" , "M" ,"1053869433" , "Manizales");
        Seller fabio = new Seller("fabio","Garcia", "52" , "H" ,"75067789" , "Manizales");

        return "Vendedor";
    }
}
