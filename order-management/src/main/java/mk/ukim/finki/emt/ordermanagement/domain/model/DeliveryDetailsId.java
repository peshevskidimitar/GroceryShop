package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class DeliveryDetailsId extends DomainObjectId {

    private DeliveryDetailsId() {
        super(DeliveryDetailsId.randomId(DeliveryDetailsId.class).getId());
    }

    public DeliveryDetailsId(@NonNull String uuid) {
        super(uuid);
    }

}
