package wedding.terminal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import wedding.controllers.*;

@Component
public class Terminal implements CommandLineRunner {

    private final AgencyController agencyController;
    private final PersonController personController;
    private final WeddingController weddingController;
    private final PresentController presentController;
    private final VenueController venueController;

    @Autowired
    public Terminal(AgencyController agencyController, PersonController personController, WeddingController weddingController, PresentController presentController, VenueController venueController) {
        this.agencyController = agencyController;
        this.personController = personController;
        this.weddingController = weddingController;
        this.presentController = presentController;
        this.venueController = venueController;
    }

    @Override
    public void run(String... strings) throws Exception {
        //this.agencyController.importAgenciesFromJson();
        //this.personController.importPeopleFromJson();
        //this.weddingController.importWeddingsFromJson();
        //this.presentController.importPresentsFromXml();
        //this.venueController.importVenuesFromXml();

        //this.agencyController.exportOrderedAgenciesToJson();
        //this.weddingController.exportWeddingsGuestList();

        //this.venueController.exportVenuesInSofia();
        this.agencyController.getAgenciesByTown();
    }
}
