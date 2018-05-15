package vehicles.console;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import vehicles.entities.Vehicle;
import vehicles.services.VehicleService;

/**
 * Created by Hristo Skipernov on 24/07/2017.
 */

@Component
public class ConsoleRunner implements CommandLineRunner {

    private final VehicleService vehicleService;

    @Autowired
    public ConsoleRunner(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @Override
    public void run(String... strings) throws Exception {
//        CargoShip cargoShip = new CargoShip();
//        cargoShip.setManufacturer("Mercedes");
//        cargoShip.setMaxLoadKilograms(100000);
//        cargoShip.setCaptainName("Ico");
//        cargoShip.setEngineType("V");
//        cargoShip.setMaxSpeed(100);
//        cargoShip.setNationality("Bulgarian");
//        cargoShip.setNumberOfEngines(1);
//        cargoShip.setPrice(15874520);
//        cargoShip.setSizeOfShipCrew(1540);
//        cargoShip.setTankCapacity(15403);
//        this.cargoShipService.create(cargoShip);
//
        Vehicle vehicle = this.vehicleService.findById(1);
        String debug = "";
    }
}
