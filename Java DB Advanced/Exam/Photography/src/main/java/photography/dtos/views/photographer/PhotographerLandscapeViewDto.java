package photography.dtos.views.photographer;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import photography.dtos.utility.LensIdUtilityDto;

import java.util.List;

public class PhotographerLandscapeViewDto {

    @Expose
    @SerializedName("FirstName")
    private String firstName;

    @Expose
    @SerializedName("LastName")
    private String lastName;

    @Expose
    @SerializedName("CameraMake")
    private String primaryCameraMake;

    @Expose
    @SerializedName("LensesCount")
    private long lensesSize;

    private List<LensIdUtilityDto> lenses;

    public PhotographerLandscapeViewDto() {
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

    public String getPrimaryCameraMake() {
        return this.primaryCameraMake;
    }

    public void setPrimaryCameraMake(String primaryCameraMake) {
        this.primaryCameraMake = primaryCameraMake;
    }

    public long getLensesSize() {
        return this.lensesSize;
    }

    public void setLensesSize(long lensesSize) {
        this.lensesSize = lensesSize;
    }

    public List<LensIdUtilityDto> getLenses() {
        return this.lenses;
    }

    public void setLenses(List<LensIdUtilityDto> lenses) {
        this.lenses = lenses;
        this.lensesSize = lenses.size();
    }
}
