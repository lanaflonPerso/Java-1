package photography.dtos.bindings.accessory;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesImportFromXmlDto {

    @XmlElement(name = "accessory")
    private List<AccessoryImportFromXmlDto> accessoryImportFromXmlDtos;

    public AccessoriesImportFromXmlDto() {
    }

    public List<AccessoryImportFromXmlDto> getAccessoryImportFromXmlDtos() {
        return this.accessoryImportFromXmlDtos;
    }

    public void setAccessoryImportFromXmlDtos(List<AccessoryImportFromXmlDto> accessoryImportFromXmlDtos) {
        this.accessoryImportFromXmlDtos = accessoryImportFromXmlDtos;
    }
}
