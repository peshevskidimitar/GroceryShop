package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.GroceryId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@Getter
public class OrderItem extends AbstractEntity<OrderItemId> {

    @AttributeOverride(name = "id", column = @Column(name = "grocery_id", nullable = false))
    private GroceryId groceryId;
    private Money price;
    @AttributeOverride(name = "quantity", column = @Column(name = "order_quantity", nullable = false))
    private Integer quantity;

    protected OrderItem() {
        super(OrderItemId.randomId(OrderItemId.class));
        this.price = null;
        this.quantity = null;
    }

    public OrderItem(@NonNull GroceryId groceryId, @NonNull Money price, @NonNull Integer quantity) {
        super(OrderItemId.randomId(OrderItemId.class));
        this.groceryId = groceryId;
        this.price = price;
        this.quantity = quantity;
    }

    public Money subtotal() {
        return price.multiply(quantity);
    }

}
