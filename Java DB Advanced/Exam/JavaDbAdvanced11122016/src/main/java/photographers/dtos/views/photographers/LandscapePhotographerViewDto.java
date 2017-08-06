package photographers.dtos.views.photographers;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import photographers.dtos.utility.LensFocalLengthDto;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class LandscapePhotographerViewDto {

    @Expose
    @SerializedName("FirstName")
    private String firstName;

    @Expose
    @SerializedName("LastName")
    private String lastName;

    @Expose
    @SerializedName("CameraMake")
    private String primaryCameraMake;

    private Set<LensFocalLengthDto> lenses;

    @Expose
    @SerializedName("LensesCount")
    private int lensesCount;

    public LandscapePhotographerViewDto() {
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

    public Set<LensFocalLengthDto> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<LensFocalLengthDto> lenses) {
        this.lenses = lenses;
        this.setLensesCount(lenses.size());
    }

    public int getLensesCount() {
        return this.lensesCount;
    }

    public void setLensesCount(int lensesCount) {
        this.lensesCount = lensesCount;
    }
}
