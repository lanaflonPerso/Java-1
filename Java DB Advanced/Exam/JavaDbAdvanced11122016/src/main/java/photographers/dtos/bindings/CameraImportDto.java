package photographers.dtos.bindings;

import com.google.gson.annotations.Expose;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class CameraImportDto {

    @Expose
    private String type;

    @Expose
    private String make;

    @Expose
    private String model;

    @Expose
    private boolean isFullFrame;

    @Expose
    private int minISO;

    @Expose
    private int maxISO;

    @Expose
    private int MaxShutterSpeed;

    @Expose
    private String maxVideoResolution;

    @Expose
    private int maxFrameRate;

    public CameraImportDto() {
    }

    public String getType() {
        return this.type;
    }

    public void setType(String type) {
        this.type = type;
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

    public int getMaxShutterSpeed() {
        return this.MaxShutterSpeed;
    }

    public void setMaxShutterSpeed(int maxShutterSpeed) {
        MaxShutterSpeed = maxShutterSpeed;
    }

    public String getMaxVideoResolution() {
        return this.maxVideoResolution;
    }

    public void setMaxVideoResolution(String maxVideoResolution) {
        this.maxVideoResolution = maxVideoResolution;
    }

    public int getMaxFrameRate() {
        return this.maxFrameRate;
    }

    public void setMaxFrameRate(int maxFrameRate) {
        this.maxFrameRate = maxFrameRate;
    }
}
