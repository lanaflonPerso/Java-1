package photographers.dtos.bindings.accessories;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

@XmlRootElement(name = "accessories")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoriesImportXmlDto {

    @XmlElement(name = "accessory")
    private List<AccessoryImportDto> accessoryImportDtos;

    public AccessoriesImportXmlDto() {
    }

    public List<AccessoryImportDto> getAccessoryImportDtos() {
        return this.accessoryImportDtos;
    }

    public void setAccessoryImportDtos(List<AccessoryImportDto> accessoryImportDtos) {
        this.accessoryImportDtos = accessoryImportDtos;
    }
}
