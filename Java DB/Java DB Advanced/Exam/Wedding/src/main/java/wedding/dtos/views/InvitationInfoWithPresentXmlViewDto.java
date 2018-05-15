package wedding.dtos.views;

import wedding.dtos.utility.PresentUtilityDto;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
public class InvitationInfoWithPresentXmlViewDto {

    @XmlValue
    private String guestFullName;

    @XmlAttribute
    private String family;

    @XmlTransient
    private PresentUtilityDto present;

    public String getGuestFullName() {
        return this.guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public PresentUtilityDto getPresent() {
        return this.present;
    }

    public void setPresent(PresentUtilityDto present) {
        this.present = present;
    }
}
