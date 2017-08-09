package wedding.dtos.views.venue;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "venues")
@XmlAccessorType(XmlAccessType.FIELD)
public class VenuesInSofiaXmlViewDto {

    @XmlElement(name = "venue")
    private List<VenueInSofiaXmlViewDto> venueInSofiaXmlViewDtos;

    public List<VenueInSofiaXmlViewDto> getVenueInSofiaXmlViewDtos() {
        return this.venueInSofiaXmlViewDtos;
    }

    public void setVenueInSofiaXmlViewDtos(List<VenueInSofiaXmlViewDto> venueInSofiaXmlViewDtos) {
        this.venueInSofiaXmlViewDtos = venueInSofiaXmlViewDtos;
    }

    @XmlAttribute(name = "name")
    public String getSofiaName() {
        return "Sofia";
    }
}
