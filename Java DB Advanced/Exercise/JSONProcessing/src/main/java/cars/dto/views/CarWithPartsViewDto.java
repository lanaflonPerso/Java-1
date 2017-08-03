package cars.dto.views;

import com.google.gson.annotations.Expose;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */

public class CarWithPartsViewDto {

    @Expose
    private CarViewDto car;

    @Expose
    private Set<PartViewDto> parts;

    public CarWithPartsViewDto() {
    }

    public CarViewDto getCar() {
        return this.car;
    }

    public void setCar(CarViewDto car) {
        this.car = car;
    }

    public Set<PartViewDto> getParts() {
        return this.parts;
    }

    public void setParts(Set<PartViewDto> parts) {
        this.parts = parts;
    }
}
