package student.system.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 22/07/2017.
 */

@Entity
@Table(name = "resources")
public class Resource {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "")
    private long id;

    @Column(name = "resource_name", nullable = false)
    private String name;

    @Column(name = "type_of_resource", nullable = false)
    private String typeOfResource;

    @Column(name = "URL", nullable = false)
    private String URL;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private Course course;

    @ManyToMany(mappedBy = "resources", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<License> licenses;

    public Resource() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTypeOfResource() {
        return this.typeOfResource;
    }

    public void setTypeOfResource(String typeOfResource) {
        this.typeOfResource = typeOfResource;
    }

    public String getURL() {
        return this.URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public Course getCourse() {
        return this.course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Set<License> getLicenses() {
        return this.licenses;
    }

    public void setLicenses(Set<License> licenses) {
        this.licenses = licenses;
    }

    @Override
    public String toString() {
        return "Resource{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", typeOfResource='" + typeOfResource + '\'' +
                ", URL='" + URL + '\'' +
                '}';
    }
}
