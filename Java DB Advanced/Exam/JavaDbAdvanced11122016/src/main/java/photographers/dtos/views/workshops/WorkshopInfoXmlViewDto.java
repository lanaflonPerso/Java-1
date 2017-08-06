package photographers.dtos.views.workshops;


import photographers.dtos.views.photographers.PhotographerCountXmlViewDto;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WorkshopInfoXmlViewDto {

    private String name;

    private double totalProfit;

    private BigDecimal pricePerParticipant;

    private PhotographerCountXmlViewDto participants;

    public WorkshopInfoXmlViewDto() {
    }

    @XmlAttribute
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlElement(name = "participants")
    public PhotographerCountXmlViewDto getParticipants() {
        return this.participants;
    }

    public void setParticipants(PhotographerCountXmlViewDto participants) {
        this.participants = participants;
    }

    @XmlAttribute(name = "total-profit")
    public double getTotalProfit() {
        return this.participants.getParticipants().size() * (this.pricePerParticipant.doubleValue() - (this.pricePerParticipant.doubleValue() * 0.2));
    }

    public void setTotalProfit(double totalProfit) {
        this.totalProfit = totalProfit;
    }

    @XmlTransient
    public BigDecimal getPricePerParticipant() {
        return this.pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }
}
