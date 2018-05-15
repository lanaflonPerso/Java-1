package wedding.entities;

import javax.persistence.Basic;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Entity
@DiscriminatorValue("cash")
public class Cash extends Present {

    @NotNull
    @Min(1)
    @Basic
    private double cashAmount;

    public Cash() {
    }

    public double getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(double cashAmount) {
        this.cashAmount = cashAmount;
    }
}
