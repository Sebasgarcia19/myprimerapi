package co.edu.umanizales.myfirsteapi.controller;

import co.edu.umanizales.myfirsteapi.model.Location;
import co.edu.umanizales.myfirsteapi.model.Seller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
@RequestMapping(path = "/Seller")
public class  SellerController {
    @GetMapping
    public Seller getSeller(){
        Location manizales = new Location("17001" ,"Manizales");
        Location pereira = new Location("66001" ,"Pereira");

        Seller sebas = new Seller("Sebas","Garcia", (byte)26 , "H" ,"1053866543" , "Manizales");
        Seller camilo = new Seller("camilo","Lopez", (byte)18 , "H" ,"1053863309" , "Pereira");
        Seller pedro = new Seller("Pedro","Hincapie", (byte)45 , "H" ,"1053855423" , "Manizales");
        Seller camila = new Seller("Camila","Flores", (byte)28 , "M" ,"1053869433" , "Manizales");
        Seller fabio = new Seller("Fabio","Garcia", (byte)52 , "H" ,"75067789" , "Manizales");

        return  sebas ;
    }

}
