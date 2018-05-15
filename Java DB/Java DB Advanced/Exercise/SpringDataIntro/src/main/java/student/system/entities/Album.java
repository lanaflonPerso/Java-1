package student.system.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Entity
@Table(name = "albums")
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "album_id")
    private long id;

    @Column(name = "album_name")
    private String name;

    @Column(name = "background_color")
    private String backgroundColor;

    @Column(name = "is_public")
    private boolean isPublic;

    @ManyToMany(mappedBy = "albums", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Set<Picture> pictures;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id")
    private User user;

    public Album() {
        this.isPublic = false;
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

    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public boolean isPublic() {
        return this.isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }
}
