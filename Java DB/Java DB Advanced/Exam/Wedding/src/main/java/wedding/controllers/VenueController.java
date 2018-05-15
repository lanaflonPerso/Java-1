package wedding.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import wedding.dtos.bindings.venue.VenuesImportFromXmlDto;
import wedding.dtos.views.venue.VenuesInSofiaXmlViewDto;
import wedding.entities.Venue;
import wedding.io.Writer;
import wedding.serializers.Serializer;
import wedding.services.VenueService;
import wedding.services.WeddingService;

import java.util.List;

@Controller
public class VenueController {
    private static final String VENUES_XML_INPUT_PATH = "/xml/input/venues.xml";
    private static final String VENUES_IN_SOFIA_XML_OUTPUT_PATH = "src/main/resources/xml/output/sofia-venues.xml";
    private static final String SUCCESSFULLY_IMPORTED_VENUE = "Successfully imported %s";

    private final Serializer xmlSerializer;
    private final VenueService venueService;
    private final WeddingService weddingService;
    private final Writer writer;

    @Autowired
    public VenueController(@Qualifier("xml") Serializer xmlSerializer, VenueService venueService, WeddingService weddingService, Writer writer) {
        this.xmlSerializer = xmlSerializer;
        this.venueService = venueService;
        this.weddingService = weddingService;
        this.writer = writer;
    }

    public void importVenuesFromXml() {
        VenuesImportFromXmlDto venuesImportFromXmlDto = this.xmlSerializer.deserialize(VenuesImportFromXmlDto.class, VENUES_XML_INPUT_PATH);
        List<Venue> venues = this.venueService.createMany(venuesImportFromXmlDto.getVenueImportFromXmlDtos());
        for (Venue venue : venues) {
            this.writer.println(SUCCESSFULLY_IMPORTED_VENUE, venue.getName());
        }

        this.weddingService.addVenues();
    }

    public void exportVenuesInSofia() {
        VenuesInSofiaXmlViewDto venuesInSofia = this.venueService.getVenuesInSofia();
        this.xmlSerializer.serialize(venuesInSofia, VENUES_IN_SOFIA_XML_OUTPUT_PATH);
    }
}
