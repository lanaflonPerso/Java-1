package photography.dtos.bindings.workshop;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WorkshopImportFromXmlDto {

    private String name;

    private Date startDate;

    private Date endDate;

    private String location;

    private BigDecimal pricePerParticipant;

    private String trainer;

    private List<WorkshopParticipantImportDto> participants;

    public WorkshopImportFromXmlDto() {
    }

    @XmlAttribute
    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @XmlAttribute(name = "start-date")
    public Date getStartDate() {
        return this.startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    @XmlAttribute(name = "end-date")
    public Date getEndDate() {
        return this.endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    @XmlAttribute
    public String getLocation() {
        return this.location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @XmlAttribute(name = "price")
    public BigDecimal getPricePerParticipant() {
        return this.pricePerParticipant;
    }

    public void setPricePerParticipant(BigDecimal pricePerParticipant) {
        this.pricePerParticipant = pricePerParticipant;
    }

    public String getTrainer() {
        return this.trainer;
    }

    public void setTrainer(String trainer) {
        this.trainer = trainer;
    }

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    public List<WorkshopParticipantImportDto> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<WorkshopParticipantImportDto> participants) {
        this.participants = participants;
    }
}
