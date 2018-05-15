package wedding.dtos.views.venue;

import wedding.dtos.utility.WeddingIdUtilityDto;

import javax.xml.bind.annotation.*;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
public class VenueInSofiaXmlViewDto {

    @XmlAttribute
    private String name;

    @XmlAttribute
    private int capacity;

    @XmlTransient
    private List<WeddingIdUtilityDto> weddings;

    @XmlElement(name = "weddings-count")
    private long weddingsCount;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return this.capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<WeddingIdUtilityDto> getWeddings() {
        return this.weddings;
    }

    public void setWeddings(List<WeddingIdUtilityDto> weddings) {
        this.weddings = weddings;
        this.weddingsCount = weddings.size();
    }

    public long getWeddingsCount() {
        return this.weddingsCount;
    }

    public void setWeddingsCount(long weddingsCount) {
        this.weddingsCount = weddingsCount;
    }
}
