package photography.dtos.views.worshop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "locations")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsByLocationViewDto {

    @XmlElement(name = "location")
    private List<WorkshopByLocationViewDto> workshopByLocationViewDtos;

    public WorkshopsByLocationViewDto() {
    }

    public List<WorkshopByLocationViewDto> getWorkshopByLocationViewDtos() {
        return this.workshopByLocationViewDtos;
    }

    public void setWorkshopByLocationViewDtos(List<WorkshopByLocationViewDto> workshopByLocationViewDtos) {
        this.workshopByLocationViewDtos = workshopByLocationViewDtos;
    }
}
