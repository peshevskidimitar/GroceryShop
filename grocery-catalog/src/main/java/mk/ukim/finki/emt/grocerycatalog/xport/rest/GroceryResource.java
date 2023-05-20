package mk.ukim.finki.emt.grocerycatalog.xport.rest;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.grocerycatalog.domain.model.Grocery;
import mk.ukim.finki.emt.grocerycatalog.domain.repository.GroceryRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/groceries")
@AllArgsConstructor
public class GroceryResource {

    private final GroceryRepository groceryRepository;

    @GetMapping
    public List<Grocery> getAll() {
        return groceryRepository.findAll();
    }

}
