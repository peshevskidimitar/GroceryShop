package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.NutritionalValue;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.Quantity;

@Getter
public class Grocery implements ValueObject {

    private final GroceryId groceryId;
    private final String name;
    private final String description;
    private final NutritionalValue nutritionalValue;
    private final Quantity quantity;
    private final Integer inStockAmount;
    private final Money price;

    protected Grocery() {
        this.groceryId = null;
        this.name = null;
        this.description = null;
        this.nutritionalValue = null;
        this.quantity = null;
        this.inStockAmount = null;
        price = null;
    }

    @JsonCreator
    public Grocery(@JsonProperty("id") GroceryId groceryId,
                   @JsonProperty("name") String name,
                   @JsonProperty("description") String description,
                   @JsonProperty("nutritionalValue") NutritionalValue nutritionalValue,
                   @JsonProperty("quantity") Quantity quantity,
                   @JsonProperty("inStockAmount") Integer inStockAmount,
                   @JsonProperty("price") Money price) {
        this.groceryId = groceryId;
        this.name = name;
        this.description = description;
        this.nutritionalValue = nutritionalValue;
        this.quantity = quantity;
        this.inStockAmount = inStockAmount;
        this.price = price;
    }

}
