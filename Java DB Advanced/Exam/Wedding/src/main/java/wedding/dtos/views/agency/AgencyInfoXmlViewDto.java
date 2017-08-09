package wedding.dtos.views.agency;

import wedding.dtos.views.WeddingInfoXmlViewDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class AgencyInfoXmlViewDto {

    private String name;

    private double profit;

    private List<WeddingInfoXmlViewDto> weddings;

    @XmlAttribute(name = "name")
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "wedding")
    public List<WeddingInfoXmlViewDto> getWeddings() {
        return this.weddings;
    }

    public void setWeddings(List<WeddingInfoXmlViewDto> weddings) {
        this.weddings = weddings;
    }

    @XmlAttribute(name = "profit")
    public double getProfit() {
        this.profit = 0.2 * this.weddings.stream().mapToDouble(WeddingInfoXmlViewDto::getCash).sum();
        return this.profit;
    }
}
