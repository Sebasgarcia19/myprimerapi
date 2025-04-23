package co.edu.umanizales.myfirsteapi.controller;

import co.edu.umanizales.myfirsteapi.model.Location;
import co.edu.umanizales.myfirsteapi.service.LocationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/location")
public class LocationController {

    private final LocationService locationService;

    public LocationController(LocationService locationService) {
        this.locationService = locationService;
    }

    @GetMapping
    public List<Location> getLocations() {
        return locationService.getLocations();
    }

    @GetMapping("/{code}")
    public Location getLocationByCode(@PathVariable String code) {
        return locationService.getLocationByCode(code);
    }

    @GetMapping("/name/{name}")
    public Location getLocationByName(@PathVariable String name) {
        return locationService.getLocationByName(name);
    }

    @GetMapping("/states")
    public List<Location> getLocationsByStates() {
        return locationService.getStates();
    }
    @GetMapping(path = "/initialLetter/{initialLetter}")
    public List<Location> getLocationByInitialLetter (@PathVariable String initialLetter)
    { return locationService.getLocationByInitialLetter(initialLetter);}

}
