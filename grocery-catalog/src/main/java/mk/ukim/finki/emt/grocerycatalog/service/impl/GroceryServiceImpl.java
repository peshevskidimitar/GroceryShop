package mk.ukim.finki.emt.grocerycatalog.service.impl;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.grocerycatalog.domain.model.Grocery;
import mk.ukim.finki.emt.grocerycatalog.domain.model.GroceryId;
import mk.ukim.finki.emt.grocerycatalog.domain.model.exception.GroceryNotFoundException;
import mk.ukim.finki.emt.grocerycatalog.domain.repository.GroceryRepository;
import mk.ukim.finki.emt.grocerycatalog.service.GroceryService;
import mk.ukim.finki.emt.grocerycatalog.service.form.GroceryForm;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class GroceryServiceImpl implements GroceryService {

    private final GroceryRepository groceryRepository;

    @Override
    public Grocery findById(GroceryId groceryId) {
        return groceryRepository.findById(groceryId)
                .orElseThrow(GroceryNotFoundException::new);
    }

    @Override
    public Grocery createGrocery(GroceryForm groceryForm) {
        Grocery grocery = Grocery.build(
                groceryForm.getName(),
                groceryForm.getDescription(),
                groceryForm.getNutritionalValue(),
                groceryForm.getQuantity(),
                groceryForm.getInStockAmount(),
                groceryForm.getFoodCategory(),
                groceryForm.getPrice()
        );
        groceryRepository.save(grocery);

        return grocery;
    }

    @Override
    public Grocery orderItemCreated(GroceryId groceryId, int quantity) {
        Grocery grocery = groceryRepository.findById(groceryId)
                .orElseThrow(GroceryNotFoundException::new);
        grocery.increaseInStockAmount(quantity);
        groceryRepository.saveAndFlush(grocery);

        return grocery;
    }

    @Override
    public Grocery orderItemRemoved(GroceryId groceryId, int quantity) {
        Grocery grocery = groceryRepository.findById(groceryId)
                .orElseThrow(GroceryNotFoundException::new);
        grocery.decreaseInStockAmount(quantity);
        groceryRepository.saveAndFlush(grocery);

        return grocery;
    }

    @Override
    public List<Grocery> getAll() {
        return groceryRepository.findAll();
    }

}
