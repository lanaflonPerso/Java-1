package wedding.dtos.bindings;

import com.google.gson.annotations.Expose;

public class AgenciesImportFromJsonDto {

    @Expose
    private String name;

    @Expose
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
