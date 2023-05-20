package mk.ukim.finki.emt.sharedkernel.domain.nutritional;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;

import javax.persistence.Embeddable;

@Embeddable
@Getter
public class NutritionalValue implements ValueObject {

    private final Double proteins;
    private final Double carbohydrates;
    private final Double fats;
    private final Double calories;

    protected NutritionalValue() {
        proteins = null;
        carbohydrates = null;
        fats = null;
        calories = null;
    }

    public NutritionalValue(@NonNull Double proteins, @NonNull Double carbohydrates, @NonNull Double fats, @NonNull Double calories) {
        this.proteins = proteins;
        this.carbohydrates = carbohydrates;
        this.fats = fats;
        this.calories = calories;
    }

    public static NutritionalValue of(@NonNull Double proteins, @NonNull Double carbohydrates, @NonNull Double fats, @NonNull Double calories) {
        return new NutritionalValue(proteins, carbohydrates, fats, calories);
    }

}
