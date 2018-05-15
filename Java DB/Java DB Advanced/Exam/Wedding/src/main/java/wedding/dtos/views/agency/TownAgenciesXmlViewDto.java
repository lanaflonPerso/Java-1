package wedding.dtos.views.agency;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class TownAgenciesXmlViewDto {

    @XmlAttribute
    private String name;

    @XmlElement(name = "agencies")
    private AgenciesInfoXmlViewDto agencies;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public AgenciesInfoXmlViewDto getAgencies() {
        return this.agencies;
    }

    public void setAgencies(AgenciesInfoXmlViewDto agencies) {
        this.agencies = agencies;
    }
}
