package photography.dtos.bindings.workshop;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "participant")
@XmlAccessorType(XmlAccessType.FIELD)
public class WorkshopParticipantImportDto {

    @XmlAttribute(name = "first-name")
    private String firstName;

    @XmlAttribute(name = "last-name")
    private String lastName;

    @XmlTransient
    private String fullName;

    public WorkshopParticipantImportDto() {
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
