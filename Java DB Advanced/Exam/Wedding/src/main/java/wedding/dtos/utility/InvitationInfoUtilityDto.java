package wedding.dtos.utility;

public class InvitationInfoUtilityDto {

    private String guestFullName;

    private boolean attending;

    private String family;

    public boolean isAttending() {
        return this.attending;
    }

    public void setAttending(boolean attending) {
        this.attending = attending;
    }

    public String getFamily() {
        return this.family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public String getGuestFullName() {
        return this.guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }
}
