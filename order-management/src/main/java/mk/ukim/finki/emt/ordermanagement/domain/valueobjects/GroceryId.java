package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class GroceryId extends DomainObjectId {

    private GroceryId() {
        super(GroceryId.randomId(GroceryId.class).getId());
    }

    public GroceryId(String uuid) {
        super(uuid);
    }

}
