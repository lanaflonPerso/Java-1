package wedding.dtos.views.agency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.List;

@XmlRootElement(name = "towns")
@XmlAccessorType(XmlAccessType.FIELD)
public class TownsAgenciesXmlViewDto {

    @XmlElement(name = "town")
    private List<TownAgenciesXmlViewDto> townAgenciesXmlViewDtos;

    public List<TownAgenciesXmlViewDto> getTownAgenciesXmlViewDtos() {
        return this.townAgenciesXmlViewDtos;
    }

    public void setTownAgenciesXmlViewDtos(List<TownAgenciesXmlViewDto> townAgenciesXmlViewDtos) {
        this.townAgenciesXmlViewDtos = townAgenciesXmlViewDtos;
    }
}
