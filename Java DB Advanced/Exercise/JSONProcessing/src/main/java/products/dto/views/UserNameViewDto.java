package products.dto.views;

import com.google.gson.annotations.Expose;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class UserNameViewDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    public UserNameViewDto() {
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
}
