package wedding.dtos.bindings.present;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "presents")
@XmlAccessorType(XmlAccessType.FIELD)
public class PresentsImportFromXmlDto {

    @XmlElement(name = "present")
    private List<PresentImportFromXmlDto> presentImportFromXmlDtos;

    public List<PresentImportFromXmlDto> getPresentImportFromXmlDtos() {
        return this.presentImportFromXmlDtos;
    }

    public void setPresentImportFromXmlDtos(List<PresentImportFromXmlDto> presentImportFromXmlDtos) {
        this.presentImportFromXmlDtos = presentImportFromXmlDtos;
    }
}
