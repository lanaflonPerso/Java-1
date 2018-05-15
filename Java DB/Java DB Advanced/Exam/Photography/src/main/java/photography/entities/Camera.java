package photography.entities;

import org.hibernate.validator.constraints.Range;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Set;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Entity
@Table(name = "cameras")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Camera implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "camera_id")
    private long id;

    @Column
    @NotNull
    private String make;

    @Column
    @NotNull
    private String model;

    @Column(name = "is_full_frame")
    private boolean isFullFrame;

    @Column(name = "min_iso")
    @NotNull
    @Range(min = 100)
    private int minISO;

    @Column(name = "max_iso")
    private int maxISO;

    @OneToMany(mappedBy = "primaryCamera")
    private Set<Photographer> photographerPrimaryCameras;

    @OneToMany(mappedBy = "secondaryCamera")
    private Set<Photographer> photographerSecondaryCameras;

    protected Camera() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMake() {
        return this.make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return this.model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public boolean isFullFrame() {
        return this.isFullFrame;
    }

    public void setFullFrame(boolean fullFrame) {
        isFullFrame = fullFrame;
    }

    public int getMinISO() {
        return this.minISO;
    }

    public void setMinISO(int minISO) {
        this.minISO = minISO;
    }

    public int getMaxISO() {
        return this.maxISO;
    }

    public void setMaxISO(int maxISO) {
        this.maxISO = maxISO;
    }

    public Set<Photographer> getPhotographerPrimaryCameras() {
        return this.photographerPrimaryCameras;
    }

    public void setPhotographerPrimaryCameras(Set<Photographer> photographerPrimaryCameras) {
        this.photographerPrimaryCameras = photographerPrimaryCameras;
    }

    public Set<Photographer> getPhotographerSecondaryCameras() {
        return this.photographerSecondaryCameras;
    }

    public void setPhotographerSecondaryCameras(Set<Photographer> photographerSecondaryCameras) {
        this.photographerSecondaryCameras = photographerSecondaryCameras;
    }

}
