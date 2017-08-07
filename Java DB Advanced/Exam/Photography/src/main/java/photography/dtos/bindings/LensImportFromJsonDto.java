package photography.dtos.bindings;

import com.google.gson.annotations.Expose;

public class LensImportFromJsonDto {

    @Expose
    private String make;

    @Expose
    private int focalLength;

    @Expose
    private double maxAperture;

    @Expose
    private String compatibleWith;

    public LensImportFromJsonDto() {
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
}
