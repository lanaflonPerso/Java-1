package photographers.dtos.views.workshops;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopByLocationXmlViewDto {

    @XmlAttribute(name = "name")
    private String location;

    @XmlElement(name = "workshop")
    private WorkshopInfoXmlViewDto workshop;

    public WorkshopByLocationXmlViewDto() {
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public WorkshopInfoXmlViewDto getWorkshop() {
        return this.workshop;
    }

    public void setWorkshop(WorkshopInfoXmlViewDto workshop) {
        this.workshop = workshop;
    }
}
