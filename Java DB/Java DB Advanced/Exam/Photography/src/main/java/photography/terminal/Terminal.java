package photography.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import photography.controllers.*;

@Component
public class Terminal implements CommandLineRunner {

    private final LensController lensController;
    private final CameraController cameraController;
    private final PhotographerController photographerController;
    private final AccessoryController accessoryController;
    private final WorkshopController workshopController;

    @Autowired
    public Terminal(LensController lensController, CameraController cameraController, PhotographerController photographerController, AccessoryController accessoryController, WorkshopController workshopController) {
        this.lensController = lensController;
        this.cameraController = cameraController;
        this.photographerController = photographerController;
        this.accessoryController = accessoryController;
        this.workshopController = workshopController;
    }

    @Override
    public void run(String... strings) throws Exception {

        // Json imports
        //this.lensController.importLenses();
        //this.cameraController.importCameras();
        //this.photographerController.importPhotographers();

        // Xml imports
        //this.accessoryController.importAccesories();
        //this.workshopController.importWorkshops();

        // Json exports
        //this.photographerController.exportOrderedPhotographers();
        //this.photographerController.exportLandscapePhotographers();

        // Xml exports
        //this.photographerController.exportSameCamerasPhotographers();
        this.workshopController.exportWorkshopsByLocation();
    }
}
