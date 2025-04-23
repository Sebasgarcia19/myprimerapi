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
        locations.add(new Location("17", "CALDAS"));
        locations.add(new Location("66", "RISARALDA"));

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
}
