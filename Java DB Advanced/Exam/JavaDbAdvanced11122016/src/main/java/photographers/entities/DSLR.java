package photographers.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * Created by Hristo Skipernov on 30/07/2017.
 */

@Entity
@Table(name = "DSLR_cameras")
@PrimaryKeyJoinColumn(name = "camera_id")
public class DSLR extends Camera {

    @Column(name = "max_shutter_speed")
    private int MaxShutterSpeed;

    public int getMaxShutterSpeed() {
        return this.MaxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        MaxShutterSpeed = maxShutterSpeed;
    }
}
