package mk.ukim.finki.emt.sharedkernel.infra;

import mk.ukim.finki.emt.sharedkernel.domain.event.DomainEvent;

public interface DomainEventPublisher {
    void publish(DomainEvent domainEvent);
}
