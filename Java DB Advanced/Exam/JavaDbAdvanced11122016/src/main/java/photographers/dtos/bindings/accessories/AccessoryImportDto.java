package photographers.dtos.bindings.accessories;

import photographers.dtos.utility.PhotographerIdUtilityDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

@XmlRootElement(name = "accessory")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccessoryImportDto {

    @XmlAttribute
    private String name;

    private PhotographerIdUtilityDto accessoryOwner;

    public AccessoryImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public PhotographerIdUtilityDto getAccessoryOwner() {
        return this.accessoryOwner;
    }

    public void setAccessoryOwner(PhotographerIdUtilityDto accessoryOwner) {
        this.accessoryOwner = accessoryOwner;
    }
}
