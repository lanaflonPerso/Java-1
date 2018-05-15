package wedding.dtos.bindings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class InvitationImportFromJsonDto {

    private String guestFirstName;

    private String guestLastName;

    private String guestMiddleNameInitial;

    @Expose
    @SerializedName("Name")
    private String guestFullName;

    @Expose
    @SerializedName("RSVP")
    private boolean attending;

    @Expose
    @SerializedName("Family")
    private String family;

    public String getGuestFullName() {
        return this.guestFullName;
    }

    public void setGuestFullName(String guestFullName) {
        this.guestFullName = guestFullName;
    }

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

    public String getGuestFirstName() {
        if (this.guestFullName != null) {
            String[] names = this.guestFullName.split("\\s+");
            this.guestFirstName = names[0];
        }
        return this.guestFirstName;
    }

    public void setGuestFirstName(String guestFirstName) {
        this.guestFirstName = guestFirstName;
    }

    public String getGuestLastName() {
        if (this.guestFullName != null) {
            String[] names = this.guestFullName.split("\\s+");
            this.guestLastName = names[2];
        }
        return this.guestLastName;
    }

    public void setGuestLastName(String guestLastName) {
        this.guestLastName = guestLastName;
    }

    public String getGuestMiddleNameInitial() {
        if (this.guestFullName != null) {
            String[] names = this.guestFullName.split("\\s+");
            this.guestMiddleNameInitial = names[1];
        }
        return this.guestMiddleNameInitial;
    }

    public void setGuestMiddleNameInitial(String guestMiddleNameInitial) {
        this.guestMiddleNameInitial = guestMiddleNameInitial;
    }
}
