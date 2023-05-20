package mk.ukim.finki.emt.grocerycatalog.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.NutritionalValue;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "grocery")
@Getter
public class Grocery extends AbstractEntity<GroceryId> {

    private String name;
    private String description;
    @Embedded
    private NutritionalValue nutritionalValue;
    @Embedded
    private Quantity quantity;
    private Integer inStockAmount;
    @Embedded
    private Money price;

    protected Grocery() {
        super(GroceryId.randomId(GroceryId.class));
    }

    private Grocery(@NonNull String name,
                    @NonNull String description,
                    @NonNull NutritionalValue nutritionalValue,
                    @NonNull Quantity quantity,
                    @NonNull Integer inStockAmount,
                    @NonNull Money price) {
        super(GroceryId.randomId(GroceryId.class));
        this.name = name;
        this.description = description;
        this.nutritionalValue = nutritionalValue;
        this.quantity = quantity;
        this.inStockAmount = inStockAmount;
        this.price = price;
    }

    public static Grocery build(@NonNull String name,
                                @NonNull String description,
                                @NonNull NutritionalValue nutritionalValue,
                                @NonNull Quantity quantity,
                                @NonNull Integer inStockAmount,
                                @NonNull Money price) {
        return new Grocery(name, description, nutritionalValue, quantity, inStockAmount, price);
    }

    public void increaseInStockAmount(@NonNull Integer amount) {
        inStockAmount += amount;
    }

    public void decreaseInStockAmount(@NonNull Integer amount) {
        inStockAmount -= amount;
    }

}
