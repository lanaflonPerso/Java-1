package wedding.dtos.bindings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;
import java.util.List;

public class WeddingsImportFromJsonDto {

    private String brideFirstName;

    private String brideLastName;

    private String brideMiddleNameInitial;

    @Expose
    @SerializedName("Bride")
    private String brideFullName;

    private String bridegroomFirstName;

    private String bridegroomLastName;

    private String bridegroomMiddleNameInitial;

    @Expose
    @SerializedName("Bridegroom")
    private String bridegroomFullName;

    @Expose
    @SerializedName("Date")
    private Date date;

    @Expose
    @SerializedName("Agency")
    private String agencyName;

    @Expose
    @SerializedName("Guests")
    private List<InvitationImportFromJsonDto> invitations;

    public String getBrideFullName() {
        return this.brideFullName;
    }

    public void setBrideFullName(String brideFullName) {
        this.brideFullName = brideFullName;
    }

    public String getBridegroomFullName() {
        return this.bridegroomFullName;
    }

    public void setBridegroomFullName(String bridegroomFullName) {
        this.bridegroomFullName = bridegroomFullName;
    }

    public Date getDate() {
        return this.date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAgencyName() {
        return this.agencyName;
    }

    public void setAgencyName(String agencyName) {
        this.agencyName = agencyName;
    }

    public List<InvitationImportFromJsonDto> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(List<InvitationImportFromJsonDto> invitations) {
        this.invitations = invitations;
    }

    public String getBrideFirstName() {
        if (this.brideFullName != null) {
            String[] names = this.brideFullName.split("\\s+");
            this.brideFirstName = names[0];
        }
        return this.brideFirstName;
    }

    public void setBrideFirstName(String brideFirstName) {
        this.brideFirstName = brideFirstName;
    }

    public String getBrideLastName() {
        if (this.brideFullName != null) {
            String[] names = this.brideFullName.split("\\s+");
            this.brideLastName = names[2];
        }
        return this.brideLastName;
    }

    public void setBrideLastName(String brideLastName) {
        this.brideLastName = brideLastName;
    }

    public String getBrideMiddleNameInitial() {
        if (this.brideFullName != null) {
            String[] names = this.brideFullName.split("\\s+");
            this.brideMiddleNameInitial = names[1];
        }
        return this.brideMiddleNameInitial;
    }

    public void setBrideMiddleNameInitial(String brideMiddleNameInitial) {
        this.brideMiddleNameInitial = brideMiddleNameInitial;
    }

    public String getBridegroomFirstName() {
        if (this.bridegroomFullName != null) {
            String[] names = this.bridegroomFullName.split("\\s+");
            this.bridegroomFirstName = names[0];
        }
        return this.bridegroomFirstName;
    }

    public void setBridegroomFirstName(String bridegroomFirstName) {
        this.bridegroomFirstName = bridegroomFirstName;
    }

    public String getBridegroomLastName() {
        if (this.bridegroomFullName != null) {
            String[] names = this.bridegroomFullName.split("\\s+");
            this.bridegroomLastName = names[2];
        }
        return this.bridegroomLastName;
    }

    public void setBridegroomLastName(String bridegroomLastName) {
        this.bridegroomLastName = bridegroomLastName;
    }

    public String getBridegroomMiddleNameInitial() {
        if (this.bridegroomFullName != null) {
            String[] names = this.bridegroomFullName.split("\\s+");
            this.bridegroomMiddleNameInitial = names[1];
        }
        return this.bridegroomMiddleNameInitial;
    }

    public void setBridegroomMiddleNameInitial(String bridegroomMiddleNameInitial) {
        this.bridegroomMiddleNameInitial = bridegroomMiddleNameInitial;
    }
}
