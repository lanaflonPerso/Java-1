package photography.dtos.bindings.workshop;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsImportFromXmlDto {

    @XmlElement(name = "workshop")
    private List<WorkshopImportFromXmlDto> workshopImportFromXmlDtos;

    public WorkshopsImportFromXmlDto() {
    }

    public List<WorkshopImportFromXmlDto> getWorkshopImportFromXmlDtos() {
        return this.workshopImportFromXmlDtos;
    }

    public void setWorkshopImportFromXmlDtos(List<WorkshopImportFromXmlDto> workshopImportFromXmlDtos) {
        this.workshopImportFromXmlDtos = workshopImportFromXmlDtos;
    }
}
