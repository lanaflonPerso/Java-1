package photographers.dtos.utility;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class PhotographerNameUtilityDto {

    private String firstName;

    private String lastName;

    private String fullName;

    public PhotographerNameUtilityDto() {
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

    public String getFullName() {
        return this.firstName + " " + this.lastName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
}
