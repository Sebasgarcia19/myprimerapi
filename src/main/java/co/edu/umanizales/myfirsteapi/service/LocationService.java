package co.edu.umanizales.myfirsteapi.service;

import co.edu.umanizales.myfirsteapi.model.Location;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.core.io.ClassPathResource;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter
public class LocationService {
    @Getter
    private List<Location> locations;

    @Value("${locations_filename}")
    private String locationsFilename;

    @PostConstruct
    public void readLocationsFromCSV() throws IOException {
        locations = new ArrayList<>();

        // Datos de prueba (puedes quitar estos si todo está en el CSV)
        locations.add(new Location("05", "ANTIOQUIA"));
        locations.add(new Location("08", "ATLANTICO"));
        locations.add(new Location("11", "BOGOTA"));
        locations.add(new Location("13", "BOLIVAR"));
        locations.add(new Location("15", "BOYACA"));
        locations.add(new Location("17", "CALDAS"));
        locations.add(new Location("18", "CAQUETA"));
        locations.add(new Location("19", "CAUCA"));
        locations.add(new Location("20", "CESAR"));
        locations.add(new Location("23", "CORDOBA"));
        locations.add(new Location("25", "CUNDINAMARCA"));
        locations.add(new Location("27", "CHOCO"));
        locations.add(new Location("41", "HUILA"));
        locations.add(new Location("44", "LA GUAJIRA"));
        locations.add(new Location("47", "MAGDALENA"));
        locations.add(new Location("50", "META"));
        locations.add(new Location("52", "NARIÑO"));
        locations.add(new Location("54", "NORTE DE SANTANDER"));
        locations.add(new Location("63", "QUINDIO"));
        locations.add(new Location("66", "RISARALDA"));
        locations.add(new Location("68", "SANTANDER"));
        locations.add(new Location("70", "SUCRE"));
        locations.add(new Location("73", "TOLIMA"));
        locations.add(new Location("76", "VALLE DEL CAUCA"));
        locations.add(new Location("85", "CASANARE"));
        locations.add(new Location("86", "PUTUMAYO"));
        locations.add(new Location("88", "ARCHIPIELAGO DE SAN ANDRES"));
        locations.add(new Location("91", "AMAZONAS"));
        locations.add(new Location("99", "VICHADA"));
        
        try (CSVReader csvReader = new CSVReader(new FileReader(
                new ClassPathResource(locationsFilename).getFile()))) {

            String[] line;
            csvReader.skip(1); // Omitir cabecera si aplica

            while ((line = csvReader.readNext()) != null) {
                // line[2] = código, line[3] = nombre del municipio
                locations.add(new Location(line[2], line[3]));
            }

        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Error leyendo el archivo CSV", e);
        }
    }

    public Location getLocationByCode(String code) {
        for (Location location : locations) {
            if (location.getCode().equals(code)) {
                return location;
            }
        }
        return null;
    }

    public Location getLocationByName(String name) {
        for (Location location : locations) {
            if (location.getDescription().equalsIgnoreCase(name)) {
                return location;
            }
        }
        return null;
    }

    public List<Location> getStates() {
        List<Location> states = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().length() == 2) {
                states.add(location);
            }
        }
        return states;
    }
    public List<Location> getLocationByInitialLetter (String initialLetter) {
        List<Location> initialLetterArray = new ArrayList<>();
        for (Location location : locations) {
            if(location.getDescription().charAt(0)== initialLetter.charAt(0)){
                initialLetterArray.add(location);
            }
        }
        return initialLetterArray;
}
    public List<Location> getStatesAndCapitals() {
        List<Location> statesandcapitals = new ArrayList<>();
        for (Location location : locations) {
            if (location.getCode().length() == 2) {
                statesandcapitals.add(location);
                statesandcapitals.add(getLocationByCode(location.getCode()+"001"));
            }
        }
        return statesandcapitals;
    }
}
