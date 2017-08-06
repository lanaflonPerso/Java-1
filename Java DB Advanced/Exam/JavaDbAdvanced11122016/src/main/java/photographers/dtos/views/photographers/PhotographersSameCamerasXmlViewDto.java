package photographers.dtos.views.photographers;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "photographers")
@XmlAccessorType(XmlAccessType.FIELD)
public class PhotographersSameCamerasXmlViewDto {

    @XmlElement(name = "photographer")
    private List<PhotographerSameCamerasXmlViewDto> photographerSameCamerasXmlViewDtos;

    public PhotographersSameCamerasXmlViewDto() {
    }

    public List<PhotographerSameCamerasXmlViewDto> getPhotographerSameCamerasXmlViewDtos() {
        return this.photographerSameCamerasXmlViewDtos;
    }

    public void setPhotographerSameCamerasXmlViewDtos(List<PhotographerSameCamerasXmlViewDto> photographerSameCamerasXmlViewDtos) {
        this.photographerSameCamerasXmlViewDtos = photographerSameCamerasXmlViewDtos;
    }
}
