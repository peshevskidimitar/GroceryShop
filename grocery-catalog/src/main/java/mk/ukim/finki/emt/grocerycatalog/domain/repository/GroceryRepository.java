package mk.ukim.finki.emt.grocerycatalog.domain.repository;

import mk.ukim.finki.emt.grocerycatalog.domain.model.Grocery;
import mk.ukim.finki.emt.grocerycatalog.domain.model.GroceryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GroceryRepository extends JpaRepository<Grocery, GroceryId> {
}
