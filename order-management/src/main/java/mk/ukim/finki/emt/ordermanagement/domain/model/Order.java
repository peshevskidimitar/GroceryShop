package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Grocery;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.*;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "grocery_order")
@Getter
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;
    @Enumerated(value = EnumType.STRING)
    private OrderStatus orderStatus;
    @Column(name = "order_currency")
    @Enumerated(value = EnumType.STRING)
    private Currency currency;
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemSet = new HashSet<>();
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    private DeliveryDetails deliveryDetails = null;

    protected Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant now, Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = now;
        this.currency = currency;
    }

    public Money total() {
        return orderItemSet.stream().map(OrderItem::subtotal).reduce(new Money(currency, 0.), Money::add);
    }

    public OrderItem addItem(@NonNull Grocery grocery, int qty) {
        Objects.requireNonNull(grocery, "Grocery must not be null.");
        var item = new OrderItem(grocery.getGroceryId(), grocery.getPrice(), qty);
        orderItemSet.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId, "Order Item must not be null");
        orderItemSet.removeIf(orderItem -> orderItem.getId().equals(orderItemId));
    }

}
