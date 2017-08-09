package wedding.dtos.views.agency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "agencies")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgenciesInfoXmlViewDto {

    @XmlElement(name = "agency")
    private List<AgencyInfoXmlViewDto> agencyInfoXmlViewDtos;

    public List<AgencyInfoXmlViewDto> getAgencyInfoXmlViewDtos() {
        return this.agencyInfoXmlViewDtos;
    }

    public void setAgencyInfoXmlViewDtos(List<AgencyInfoXmlViewDto> agencyInfoXmlViewDtos) {
        this.agencyInfoXmlViewDtos = agencyInfoXmlViewDtos;
    }
}
