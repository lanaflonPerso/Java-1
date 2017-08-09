package wedding.dtos.bindings.venue;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesImportFromXmlDto {

    @XmlElement(name = "venue")
    private List<VenueImportFromXmlDto> venueImportFromXmlDtos;

    public List<VenueImportFromXmlDto> getVenueImportFromXmlDtos() {
        return this.venueImportFromXmlDtos;
    }

    public void setVenueImportFromXmlDtos(List<VenueImportFromXmlDto> venueImportFromXmlDtos) {
        this.venueImportFromXmlDtos = venueImportFromXmlDtos;
    }
}
