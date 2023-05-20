package mk.ukim.finki.emt.grocerycatalog.service;

import mk.ukim.finki.emt.grocerycatalog.domain.model.Grocery;
import mk.ukim.finki.emt.grocerycatalog.domain.model.GroceryId;
import mk.ukim.finki.emt.grocerycatalog.service.form.GroceryForm;

import java.util.List;

public interface GroceryService {
    Grocery findById(GroceryId groceryId);
    Grocery createGrocery(GroceryForm groceryForm);
    Grocery orderItemCreated(GroceryId groceryId, int quantity);
    Grocery orderItemRemoved(GroceryId groceryId, int quantity);
    List<Grocery> getAll();
}
