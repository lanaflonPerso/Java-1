package wedding.entities;

import wedding.annotations.GiftSize;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("gift")
public class Gift extends Present {

    @NotNull
    @Basic
    private String name;

    @Basic
    @GiftSize
    private String size;

    public Gift() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSize() {
        return this.size;
    }

    public void setSize(String size) {
        if (size == null) {
            this.size = "Not Specified";
        } else {
            this.size = size;
        }
    }
}
