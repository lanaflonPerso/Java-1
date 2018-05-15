package photography.dtos.views.photographer;

import photography.dtos.utility.LensInfoUtilityDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlRootElement(name = "photographer")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PhotographerSameCamerasViewDto {

    private String firstName;

    private String lastName;

    private String fullName;

    private String primaryCameraMake;

    private String primaryCameraModel;

    private String cameraMakeAndModel;

    private List<LensInfoUtilityDto> lenses;

    public PhotographerSameCamerasViewDto() {
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
    public String getPrimaryCameraMake() {
        return this.primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    @XmlTransient
    public String getPrimaryCameraModel() {
        return this.primaryCameraModel;
    }

    public void setPrimaryCameraModel(String primaryCameraModel) {
        this.primaryCameraModel = primaryCameraModel;
    }

    @XmlAttribute(name = "primary-camera")
    public String getCameraMakeAndModel() {
        return this.cameraMakeAndModel;
    }

    public void setCameraMakeAndModel(String cameraMakeAndModel) {
        this.cameraMakeAndModel = cameraMakeAndModel;
    }

    @XmlElement(name = "lenses")
    public List<LensInfoUtilityDto> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<LensInfoUtilityDto> lenses) {
        this.lenses = lenses;
    }

}
