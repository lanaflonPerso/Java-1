package products.dto.bindings;

import com.google.gson.annotations.Expose;

/**
 * Created by Hristo Skipernov on 01/08/2017.
 */

public class UserImportDto {

    @Expose
    private String firstName;

    @Expose
    private String lastName;

    @Expose
    private int age;

    public UserImportDto() {
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

    public int getAge() {
        return this.age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
