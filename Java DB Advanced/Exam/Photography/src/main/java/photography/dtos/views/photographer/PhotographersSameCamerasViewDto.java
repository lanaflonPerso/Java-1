package photography.dtos.views.photographer;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographersSameCamerasViewDto {

    @XmlElement(name = "photographer")
    private List<PhotographerSameCamerasViewDto> photographerSameCamerasViewDtos;

    public PhotographersSameCamerasViewDto() {
    }

    public List<PhotographerSameCamerasViewDto> getPhotographerSameCamerasViewDtos() {
        return this.photographerSameCamerasViewDtos;
    }

    public void setPhotographerSameCamerasViewDtos(List<PhotographerSameCamerasViewDto> photographerSameCamerasViewDtos) {
        this.photographerSameCamerasViewDtos = photographerSameCamerasViewDtos;
    }
}
