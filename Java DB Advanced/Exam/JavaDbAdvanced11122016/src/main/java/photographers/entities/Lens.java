package photographers.entities;

import javax.persistence.*;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Entity
@Table(name = "lenses")
public class Lens {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "lens_id")
    private long id;

    @Basic
    private String make;

    @Column(name = "focal_length")
    private int focalLength;

    @Column(name = "max_aperture")
    private double maxAperture;

    @Column(name = "compatible_with")
    private String compatibleWith;

    @ManyToOne
    @JoinColumn(name = "lens_owner_id")
    private Photographer lensOwner;

    public Lens() {
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

    public int getFocalLength() {
        return this.focalLength;
    }

    public void setFocalLength(int focalLength) {
        this.focalLength = focalLength;
    }

    public double getMaxAperture() {
        return this.maxAperture;
    }

    public void setMaxAperture(double maxAperture) {
        this.maxAperture = maxAperture;
    }

    public String getCompatibleWith() {
        return this.compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

    public Photographer getLensOwner() {
        return this.lensOwner;
    }

    public void setLensOwner(Photographer lensOwner) {
        this.lensOwner = lensOwner;
    }
}
