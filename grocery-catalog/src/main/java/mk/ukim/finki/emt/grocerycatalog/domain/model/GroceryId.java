package mk.ukim.finki.emt.grocerycatalog.domain.model;

import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.DomainObjectId;

public class GroceryId extends DomainObjectId {

    private GroceryId() {
        super(GroceryId.randomId(GroceryId.class).getId());
    }

    public GroceryId(@NonNull String uuid) {
        super(uuid);
    }

    public static GroceryId of(String uuid) {
        return new GroceryId(uuid);
    }

}
