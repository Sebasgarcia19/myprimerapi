package co.edu.umanizales.myfirsteapi.controller;

import co.edu.umanizales.myfirsteapi.model.Location;
import co.edu.umanizales.myfirsteapi.model.Store;
import co.edu.umanizales.myfirsteapi.service.LocationService;
import co.edu.umanizales.myfirsteapi.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/store" )
public class StoreController {
    @Autowired
    private StoreService storeService;

    @GetMapping
    public List<Store> getStore() {
        return storeService.getStores();
    }


}

