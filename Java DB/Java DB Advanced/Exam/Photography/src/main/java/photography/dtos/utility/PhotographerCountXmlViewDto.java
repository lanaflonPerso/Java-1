package photography.dtos.utility;

import javax.xml.bind.annotation.*;
import java.util.List;
import java.util.stream.Collectors;

@XmlRootElement(name = "participants")
@XmlAccessorType(XmlAccessType.PROPERTY)
public class PhotographerCountXmlViewDto {

    private int count;

    private List<String> participants;

    public PhotographerCountXmlViewDto() {
    }

    @XmlAttribute(name = "count")
    public int getCount() {
        return this.participants.size();
    }

    public void setCount(int count) {
        this.count = count;
    }

    @XmlElement(name = "participant")
    public List<String> getParticipants() {
        return this.participants;
    }

    public void setParticipants(List<PhotographerNameUtilityDto> participants) {
        this.participants = participants.stream().map(PhotographerNameUtilityDto::getFullName).collect(Collectors.toList());
    }
}
