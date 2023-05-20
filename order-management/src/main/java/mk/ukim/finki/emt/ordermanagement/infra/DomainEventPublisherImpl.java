package mk.ukim.finki.emt.ordermanagement.infra;

import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;
import mk.ukim.finki.emt.sharedkernel.infra.DomainEventPublisher;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class DomainEventPublisherImpl implements DomainEventPublisher {

    private final KafkaTemplate<String, String> kafkaTemplate;

    @Override
    public void publish(DomainEvent domainEvent) {
        kafkaTemplate.send(domainEvent.topic(), domainEvent.toJson());
    }

}