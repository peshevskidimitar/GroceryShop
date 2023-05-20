package mk.ukim.finki.emt.grocerycatalog.config;

import mk.ukim.finki.emt.grocerycatalog.domain.model.Grocery;
import mk.ukim.finki.emt.grocerycatalog.domain.repository.GroceryRepository;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.FoodCategory;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.MeasurementUnit;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.NutritionalValue;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.Quantity;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Arrays;

@Component
public class DataInitializer {

    private final GroceryRepository groceryRepository;

    public DataInitializer(GroceryRepository groceryRepository) {
        this.groceryRepository = groceryRepository;
    }

    @PostConstruct
    public void initData() {
        Grocery grocery1 = Grocery.build(
                "Tomato",
                "This is a tomato.",
                NutritionalValue.of(2., 15., 0., 50.),
                Quantity.of(1, MeasurementUnit.KILOGRAMS),
                10,
                FoodCategory.VEGETABLE,
                Money.valueOf(Currency.MKD, 75.)
        );
        Grocery grocery2 = Grocery.build(
                "Orange",
                "This is an orange.",
                NutritionalValue.of(1., 20., 0.5, 75.),
                Quantity.of(2, MeasurementUnit.KILOGRAMS),
                30,
                FoodCategory.FRUIT,
                Money.valueOf(Currency.MKD, 50.)
        );

        if (groceryRepository.findAll().isEmpty())
            groceryRepository.saveAll(Arrays.asList(grocery1, grocery2));
    }

}
