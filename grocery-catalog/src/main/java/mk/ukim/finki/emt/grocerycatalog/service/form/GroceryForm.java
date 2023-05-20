package mk.ukim.finki.emt.grocerycatalog.service.form;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.NutritionalValue;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.Quantity;

@Getter
public class GroceryForm {

    private String name;
    private String description;
    private NutritionalValue nutritionalValue;
    private Quantity quantity;
    private Integer inStockAmount;
    private Money price;

}
