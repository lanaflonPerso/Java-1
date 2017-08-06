package photographers.dtos.views.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsByLocationXmlViewDto {

    @XmlElement(name = "location")
    private List<WorkshopByLocationXmlViewDto> workshopByLocationXmlViewDtos;

    public WorkshopsByLocationXmlViewDto() {
    }

    public List<WorkshopByLocationXmlViewDto> getWorkshopByLocationXmlViewDtos() {
        return this.workshopByLocationXmlViewDtos;
    }

    public void setWorkshopByLocationXmlViewDtos(List<WorkshopByLocationXmlViewDto> workshopByLocationXmlViewDtos) {
        this.workshopByLocationXmlViewDtos = workshopByLocationXmlViewDtos;
    }
}
