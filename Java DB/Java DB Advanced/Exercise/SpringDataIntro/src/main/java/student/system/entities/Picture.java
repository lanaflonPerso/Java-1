package student.system.entities;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 25/07/2017.
 */

@Entity
@Table(name = "pictures")
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "picture_id")
    private long id;

    @Basic
    private String title;

    @Basic
    private String caption;

    @Basic
    private String path;

    @ManyToMany
    @JoinTable(name = "pictures_albums",
    joinColumns = @JoinColumn(name = "picture_id"),
    inverseJoinColumns = @JoinColumn(name = "album_id"),
    foreignKey = @ForeignKey(name = "fk_pictures_albums_pictures"),
    inverseForeignKey = @ForeignKey(name = "fk_pictures_albums_albums"))
    private Set<Album> albums;


}
