package photographers.dtos.utility;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public abstract class CameraIdAndMakeDto {

    private long id;

    private String make;

    protected CameraIdAndMakeDto() {
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
}
