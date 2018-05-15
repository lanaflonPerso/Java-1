package photography.dtos.views.worshop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "location")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopByLocationViewDto {

    @XmlAttribute(name = "name")
    private String location;

    @XmlElement(name = "workshop")
    private WorkshopInfoViewDto workshop;

    public WorkshopByLocationViewDto() {
    }

    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public WorkshopInfoViewDto getWorkshop() {
        return this.workshop;
    }

    public void setWorkshop(WorkshopInfoViewDto workshop) {
        this.workshop = workshop;
    }
}
