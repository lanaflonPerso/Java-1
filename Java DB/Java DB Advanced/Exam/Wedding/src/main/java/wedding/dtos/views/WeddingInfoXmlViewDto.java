package wedding.dtos.views;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.PROPERTY)
public class WeddingInfoXmlViewDto {

    private double cash;

    private long presents;

    private String brideFullName;

    private String bridegroomFullName;

    private List<InvitationInfoWithPresentXmlViewDto> invitations;

    @XmlAttribute(name = "cash")
    public double getCash() {
        this.cash = invitations.stream().filter(i -> i.getPresent() != null && i.getPresent().getCashAmount() != null).mapToDouble(i -> i.getPresent().getCashAmount()).sum();
        return this.cash;
    }

    public void setCash(double cash) {
        this.cash = cash;
    }

    @XmlAttribute(name = "presents")
    public long getPresents() {
        this.presents = invitations.stream().filter(i -> i.getPresent() != null && ("Small".equals(i.getPresent().getSize()) || "Medium".equals(i.getPresent().getSize()) || "Large".equals(i.getPresent().getSize()))).count();
        return this.presents;
    }

    public void setPresents(long presents) {
        this.presents = presents;
    }

    @XmlElement(name = "bride")
    public String getBrideFullName() {
        return this.brideFullName;
    }

    public void setBrideFullName(String brideFullName) {
        this.brideFullName = brideFullName;
    }

    @XmlElement(name = "bridegroom")
    public String getBridegroomFullName() {
        return this.bridegroomFullName;
    }

    public void setBridegroomFullName(String bridegroomFullName) {
        this.bridegroomFullName = bridegroomFullName;
    }

    @XmlElementWrapper(name = "guests")
    @XmlElement(name = "guest")
    public List<InvitationInfoWithPresentXmlViewDto> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(List<InvitationInfoWithPresentXmlViewDto> invitations) {
        this.invitations = invitations;
    }
}
