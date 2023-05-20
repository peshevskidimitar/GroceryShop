package mk.ukim.finki.emt.ordermanagement.domain.model;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "delivery_details")
@Getter
public class DeliveryDetails extends AbstractEntity<DeliveryDetailsId> {

    private String customerName;
    private String phoneNumber;
    private String address;

    protected DeliveryDetails() {
        super(DeliveryDetailsId.randomId(DeliveryDetailsId.class));
    }

    public DeliveryDetails(@NonNull String customerName, @NonNull String phoneNumber, @NonNull String address) {
        super(DeliveryDetailsId.randomId(DeliveryDetailsId.class));
        this.customerName = customerName;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

}
