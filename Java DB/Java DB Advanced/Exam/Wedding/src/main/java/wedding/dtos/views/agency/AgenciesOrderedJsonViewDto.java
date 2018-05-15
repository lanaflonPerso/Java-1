package wedding.dtos.views.agency;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AgenciesOrderedJsonViewDto {

    @Expose
    private String name;

    @Expose
    @SerializedName("count")
    private int employeesCount;

    @Expose
    private String town;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getEmployeesCount() {
        return this.employeesCount;
    }

    public void setEmployeesCount(int employeesCount) {
        this.employeesCount = employeesCount;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
