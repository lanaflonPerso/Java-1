package wedding.dtos.utility;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

@XmlAccessorType(XmlAccessType.FIELD)
public class PresentUtilityDto {

    @XmlTransient
    private long id;

    @XmlTransient
    private Double cashAmount;

    @XmlTransient
    private String name;

    @XmlTransient
    private String size;

    public Double getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(Double cashAmount) {

        this.cashAmount = cashAmount;
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
        this.size = size;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
