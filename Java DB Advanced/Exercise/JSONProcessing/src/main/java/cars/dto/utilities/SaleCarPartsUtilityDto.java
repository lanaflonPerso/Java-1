package cars.dto.utilities;

import java.util.Set;

/**
 * Created by Hristo Skipernov on 03/08/2017.
 */
public class SaleCarPartsUtilityDto {

    private Set<PartPriceUtilityDto> carParts;

    public SaleCarPartsUtilityDto() {
    }

    public Set<PartPriceUtilityDto> getCarParts() {
        return this.carParts;
    }

    public void setCarParts(Set<PartPriceUtilityDto> carParts) {
        this.carParts = carParts;
    }
}
