package mk.ukim.finki.emt.sharedkernel.domain.event.order;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;

@Getter
public class OrderItemCreated extends DomainEvent {

    private String productId;
    private int quantity;

    public OrderItemCreated() {
        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
    }

    public OrderItemCreated(String productId, int quantity) {
        super(TopicHolder.TOPIC_ORDER_ITEM_CREATED);
        this.productId = productId;
        this.quantity = quantity;
    }

}
