package wedding.dtos.bindings.present;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class PresentImportFromXmlDto {

    @XmlAttribute
    private String type;

    @XmlAttribute(name = "invitation-id")
    private long invitationId;

    @XmlAttribute(name = "amount")
    private double cashAmount;

    @XmlAttribute(name = "present-name")
    private String name;

    @XmlAttribute
    private String size;

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getInvitationId() {
        return this.invitationId;
    }

    public void setInvitationId(long invitationId) {
        this.invitationId = invitationId;
    }

    public double getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
