package wedding.dtos.views.agency;

import com.google.gson.annotations.Expose;

public class AgencyNameTownViewDto {

    @Expose
    private String name;

    @Expose
    private String town;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTown() {
        return this.town;
    }

    public void setTown(String town) {
        this.town = town;
    }
}
