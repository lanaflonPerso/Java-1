package photographers.dtos.bindings.workshops;

import javax.xml.bind.annotation.*;
import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@XmlRootElement(name = "workshop")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class WorkshopImportDto {

    private String name;

    private Date startDate;

    private Date endDate;

    private String location;

    private BigDecimal pricePerParticipant;

    private long trainerId;

    private String fullName;

    private String trainerFirstName;

    private String trainerLastName;

    private Set<WorkshopPhotographerImportDto> participants;

    public WorkshopImportDto() {
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

    public long getTrainerId() {
        return this.trainerId;
    }

    public void setTrainerId(long trainerId) {
        this.trainerId = trainerId;
    }

    @XmlElement(name = "trainer")
    public String getFullName() {
        return this.fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
        if (fullName != null) {
            String[] nameTokens = fullName.split("\\s+");
            if (nameTokens.length == 2) {
                this.setTrainerFirstName(nameTokens[0]);
                this.setTrainerLastName(nameTokens[1]);
            }
        }
    }

    public String getTrainerFirstName() {
        return this.trainerFirstName;
    }

    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    public String getTrainerLastName() {
        return this.trainerLastName;
    }

    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }

    @XmlElementWrapper(name = "participants")
    @XmlElement(name = "participant")
    public Set<WorkshopPhotographerImportDto> getParticipants() {
        return this.participants;
    }

    public void setParticipants(Set<WorkshopPhotographerImportDto> participants) {
        this.participants = participants;
    }
}
