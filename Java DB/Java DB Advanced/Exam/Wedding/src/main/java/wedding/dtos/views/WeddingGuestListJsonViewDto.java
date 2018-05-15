package wedding.dtos.views;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import wedding.dtos.utility.InvitationInfoUtilityDto;
import wedding.dtos.views.agency.AgencyNameTownViewDto;

import java.util.List;
import java.util.stream.Collectors;

public class WeddingGuestListJsonViewDto {

    @Expose
    @SerializedName("bride")
    private String brideFullName;

    @Expose
    @SerializedName("bridegroom")
    private String bridegroomFullName;

    @Expose
    private AgencyNameTownViewDto agency;

    private List<InvitationInfoUtilityDto> invitations;

    @Expose
    private long invitedGuests;

    @Expose
    private long brideGuests;

    @Expose
    private long bridegroomGuests;

    @Expose
    private long attendingGuests;

    @Expose
    private List<String> guests;

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

    public AgencyNameTownViewDto getAgency() {
        return this.agency;
    }

    public void setAgency(AgencyNameTownViewDto agency) {
        this.agency = agency;
    }

    public List<InvitationInfoUtilityDto> getInvitations() {
        return this.invitations;
    }

    public void setInvitations(List<InvitationInfoUtilityDto> invitations) {
        this.invitations = invitations;
        this.invitedGuests = invitations.size();
        this.brideGuests = invitations.stream().filter(i -> i.getFamily().equals("Bride")).count();
        this.bridegroomGuests = invitations.stream().filter(i -> i.getFamily().equals("Bridegroom")).count();
        this.attendingGuests = invitations.stream().filter(InvitationInfoUtilityDto::isAttending).count();
        this.guests = invitations.stream().filter(InvitationInfoUtilityDto::isAttending).map(InvitationInfoUtilityDto::getGuestFullName).collect(Collectors.toList());
    }

    public long getInvitedGuests() {
        return this.invitedGuests;
    }

    public void setInvitedGuests(long invitedGuests) {
        this.invitedGuests = invitedGuests;
    }

    public long getBrideGuests() {
        return this.brideGuests;
    }

    public void setBrideGuests(long brideGuests) {
        this.brideGuests = brideGuests;
    }

    public long getBridegroomGuests() {
        return this.bridegroomGuests;
    }

    public void setBridegroomGuests(long bridegroomGuests) {
        this.bridegroomGuests = bridegroomGuests;
    }

    public long getAttendingGuests() {
        return this.attendingGuests;
    }

    public void setAttendingGuests(long attendingGuests) {
        this.attendingGuests = attendingGuests;
    }

    public void setAttendingGuests(int attendingGuests) {
        this.attendingGuests = attendingGuests;
    }

    public List<String> getGuests() {
        return this.guests;
    }

    public void setGuests(List<String> guests) {
        this.guests = guests;
    }
}
