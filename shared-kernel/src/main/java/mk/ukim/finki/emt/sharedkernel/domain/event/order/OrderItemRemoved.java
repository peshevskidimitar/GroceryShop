package mk.ukim.finki.emt.sharedkernel.domain.event.order;

import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;

@Getter
public class OrderItemRemoved extends DomainEvent {

    private String productId;
    private int quantity;

    public OrderItemRemoved() {
        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
    }

    public OrderItemRemoved(String productId, int quantity) {
        super(TopicHolder.TOPIC_ORDER_ITEM_REMOVED);
        this.productId = productId;
        this.quantity = quantity;
    }

}