package photographers.dtos.bindings.workshops;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "workshops")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopsImportDto {

    @XmlElement(name = "workshop")
    private List<WorkshopImportDto> workshopImportDtos;

    public WorkshopsImportDto() {
    }

    public List<WorkshopImportDto> getWorkshopImportDtos() {
        return this.workshopImportDtos;
    }

    public void setWorkshopImportDtos(List<WorkshopImportDto> workshopImportDtos) {
        this.workshopImportDtos = workshopImportDtos;
    }
}
