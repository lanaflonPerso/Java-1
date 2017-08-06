package photographers.dtos.views.lenses;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "lenses")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class LensInfoXmlViewDto {

    private String make;

    private int focalLength;

    private double maxAperture;

    private String lensInfo;

    public LensInfoXmlViewDto() {
    }

    @XmlTransient
    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    @XmlTransient
    public int getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    @XmlTransient
    public double getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    @XmlElement(name = "lens")
    public String getLensInfo() {
        return String.format("%s %dmm f%.1f", this.make, this.focalLength, this.maxAperture);
    }

    public void setLensInfo(String lensInfo) {
        this.lensInfo = lensInfo;
    }
}
