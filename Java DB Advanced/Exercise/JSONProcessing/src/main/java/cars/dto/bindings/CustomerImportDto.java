package cars.dto.bindings;

import com.google.gson.annotations.Expose;

import java.util.Date;

/**
 * Created by Hristo Skipernov on 02/08/2017.
 */

public class CustomerImportDto {

    @Expose
    private String name;

    @Expose
    private Date birthDate;

    @Expose
    private boolean isYoungDriver;

    public CustomerImportDto() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getBirthDate() {
        return this.birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public boolean isYoungDriver() {
        return this.isYoungDriver;
    }

    public void setYoungDriver(boolean youngDriver) {
        isYoungDriver = youngDriver;
    }
}
