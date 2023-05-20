package mk.ukim.finki.emt.sharedkernel.domain.nutritional;

import lombok.Getter;
import lombok.NonNull;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Embeddable
@Getter
public class Quantity {

    private Integer quantity;
    @Enumerated(value = EnumType.STRING)
    private MeasurementUnit measurementUnit;

    protected Quantity() {
        quantity = null;
        measurementUnit = null;
    }

    private Quantity(@NonNull Integer quantity, @NonNull MeasurementUnit measurementUnit) {
        this.quantity = quantity;
        this.measurementUnit = measurementUnit;
    }

    public static Quantity of(@NonNull Integer quantity, @NonNull MeasurementUnit measurementUnit) {
        return new Quantity(quantity, measurementUnit);
    }

}
