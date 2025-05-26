package co.edu.umanizales.myfirsteapi.service;

import co.edu.umanizales.myfirsteapi.model.Store;
import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import jakarta.annotation.PostConstruct;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
@Getter

public class StoreService {

    private List<Store> store = new ArrayList<>();

    @Value("${stores_filename}")
    private String storesfilename;

    @Autowired
    private LocationService locationService;

    public StoreService(LocationService locationService) {
        this.locationService = locationService;
    }

    @PostConstruct
    public void readStoreFromCSV() throws IOException, URISyntaxException {
        store = new ArrayList<>();
        Path pathFile = Paths.get(getClass().getClassLoader().getResource(storesfilename).toURI());

        try (CSVReader csvReader = new CSVReader(new FileReader(pathFile.toString()))) {
            String[] line;
            csvReader.skip(1);
            // Ciclo para Leer linea por linea y agrega tienda
            while ((line = csvReader.readNext()) != null) {

                // Crear un nuevo objeto Location y agregarlo a la lista
                store.add(new Store(line[1], line[0], line[2], locationService.getLocationByCode(line[3])));

            }
        } catch (CsvValidationException e) {
            throw new RuntimeException(e);  // Lanza la excepción para que pueda manejarse en la capa superior si es necesario

        }
    }

    public List<Store> getAllStores() {
        return store;
    }

    public Store getStoreByCode(String code) {
        for (Store store : store) {
            if (store.getCode().equals(code)) {
                return store;
            }
        }
        return null;
    }
}