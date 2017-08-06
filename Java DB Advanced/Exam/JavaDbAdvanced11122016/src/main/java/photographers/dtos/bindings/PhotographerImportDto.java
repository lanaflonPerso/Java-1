package photographers.dtos.bindings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import photographers.dtos.utility.CameraIdAndMakeDto;
import photographers.dtos.utility.LensIdAndCompatibleDto;

import java.util.List;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class PhotographerImportDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String phone;

    private CameraIdAndMakeDto primaryCamera;

    private CameraIdAndMakeDto secondaryCamera;

    private Set<LensIdAndCompatibleDto> lenses;

    @Expose
    @SerializedName("lenses")
    private List<Long> lensesIds;

    public PhotographerImportDto() {
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

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public CameraIdAndMakeDto getPrimaryCamera() {
        return this.primaryCamera;
    }

    public void setPrimaryCamera(CameraIdAndMakeDto primaryCamera) {
        this.primaryCamera = primaryCamera;
    }

    public CameraIdAndMakeDto getSecondaryCamera() {
        return this.secondaryCamera;
    }

    public void setSecondaryCamera(CameraIdAndMakeDto secondaryCamera) {
        this.secondaryCamera = secondaryCamera;
    }

    public Set<LensIdAndCompatibleDto> getLenses() {
        return this.lenses;
    }

    public void setLenses(Set<LensIdAndCompatibleDto> lenses) {
        this.lenses = lenses;
    }

    public List<Long> getLensesIds() {
        return this.lensesIds;
    }

    public void setLensesIds(List<Long> lensesIds) {
        this.lensesIds = lensesIds;
    }
}
