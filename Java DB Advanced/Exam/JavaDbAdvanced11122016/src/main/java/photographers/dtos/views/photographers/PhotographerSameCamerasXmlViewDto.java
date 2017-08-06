package photographers.dtos.views.photographers;

import photographers.dtos.utility.CameraMakeAndModelXmlViewDto;
import photographers.dtos.views.lenses.LensInfoXmlViewDto;

import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "photographer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PhotographerSameCamerasXmlViewDto {

    private String firstName;

    private String lastName;

    private String fullName;

    private CameraMakeAndModelXmlViewDto primaryCamera;

    private String makeAndModel;

    private List<LensInfoXmlViewDto> lenses;

    public PhotographerSameCamerasXmlViewDto() {
    }

    @XmlTransient
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @XmlTransient
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @XmlAttribute(name = "name")
    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    @XmlTransient
    public CameraMakeAndModelXmlViewDto getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(CameraMakeAndModelXmlViewDto primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    @XmlAttribute(name = "primary-camera")
    public String getMakeAndModel() {
        return this.primaryCamera.getMake() + " " + this.primaryCamera.getModel();
    }

    public void setMakeAndModel(String makeAndModel) {
        this.makeAndModel = makeAndModel;
    }

    public List<LensInfoXmlViewDto> getLenses() {
        return this.lenses;
    }

    @XmlElement(name = "lenses")
    public void setLenses(List<LensInfoXmlViewDto> lenses) {
        this.lenses = lenses;
    }

    private void beforeMarshal(Marshaller marshaller) {
        if (lenses != null && lenses.isEmpty())
            lenses = null;
    }

}
