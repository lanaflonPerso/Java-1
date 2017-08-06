package photographers.dtos.utility;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class LensIdAndCompatibleDto {

    private long id;

    private String compatibleWith;

    public LensIdAndCompatibleDto() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCompatibleWith() {
        return this.compatibleWith;
    }

    public void setCompatibleWith(String compatibleWith) {
        this.compatibleWith = compatibleWith;
    }

}
