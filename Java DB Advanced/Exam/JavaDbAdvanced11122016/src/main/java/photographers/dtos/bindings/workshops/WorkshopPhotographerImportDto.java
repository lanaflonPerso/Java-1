package photographers.dtos.bindings.workshops;

import photographers.dtos.utility.CameraIdAndMakeDto;
import photographers.dtos.utility.LensIdAndCompatibleDto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopPhotographerImportDto {

    private long id;

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    private String phone;

    private CameraIdAndMakeDto primaryCamera;

    private CameraIdAndMakeDto secondaryCamera;

    private Set<LensIdAndCompatibleDto> lenses;

    private List<Long> lensesIds;

    public WorkshopPhotographerImportDto() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CameraIdAndMakeDto getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(CameraIdAndMakeDto primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public CameraIdAndMakeDto getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(CameraIdAndMakeDto secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<LensIdAndCompatibleDto> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<LensIdAndCompatibleDto> lenses) {
        this.lenses = lenses;
    }

    public List<Long> getLensesIds() {
        return this.lensesIds;
    }

    public void setLensesIds(List<Long> lensesIds) {
        this.lensesIds = lensesIds;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
