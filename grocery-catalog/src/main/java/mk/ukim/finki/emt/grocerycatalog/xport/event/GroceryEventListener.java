package mk.ukim.finki.emt.grocerycatalog.xport.event;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.grocerycatalog.domain.model.GroceryId;
import mk.ukim.finki.emt.grocerycatalog.service.GroceryService;
import mk.ukim.finki.emt.sharedkernel.config.TopicHolder;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.domain.event.order.OrderItemCreated;
import mk.ukim.finki.emt.sharedkernel.domain.event.order.OrderItemRemoved;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroceryEventListener {

    private final GroceryService groceryService;

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_CREATED, groupId = "productCatalog")
    public void consumeOrderItemCreatedEvent(String jsonMessage) {
        try {
            OrderItemCreated event = DomainEvent.fromJson(jsonMessage, OrderItemCreated.class);
            groceryService.orderItemCreated(GroceryId.of(event.getProductId()), event.getQuantity());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @KafkaListener(topics = TopicHolder.TOPIC_ORDER_ITEM_REMOVED, groupId = "productCatalog")
    public void consumeOrderItemRemovedEvent(String jsonMessage) {
        try {
            OrderItemRemoved event = DomainEvent.fromJson(jsonMessage, OrderItemRemoved.class);
            groceryService.orderItemRemoved(GroceryId.of(event.getProductId()), event.getQuantity());
        } catch (Exception e) {

        }
    }

}
