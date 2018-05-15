package photography.dtos.bindings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PhotographerImportFromJsonDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private String phone;

    @Expose
    @SerializedName("lenses")
    private List<Long> lensesIds;

    public PhotographerImportFromJsonDto() {
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

    public List<Long> getLensesIds() {
        return this.lensesIds;
    }

    public void setLensesIds(List<Long> lensesIds) {
        this.lensesIds = lensesIds;
    }
}

