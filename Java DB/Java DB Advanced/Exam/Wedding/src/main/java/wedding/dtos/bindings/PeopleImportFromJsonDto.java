package wedding.dtos.bindings;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class PeopleImportFromJsonDto {

    @Expose
    private String firstName;

    @Expose
    @SerializedName("middleInitial")
    private String middleNameInitial;

    @Expose
    private String lastName;

    @Expose
    private String gender;

    @Expose
    @SerializedName("birthday")
    private Date birthDate;

    @Expose
    private String phone;

    @Expose
    private String email;

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleNameInitial() {
        return this.middleNameInitial;
    }

    public void setMiddleNameInitial(String middleNameInitial) {
        this.middleNameInitial = middleNameInitial;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return this.gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
