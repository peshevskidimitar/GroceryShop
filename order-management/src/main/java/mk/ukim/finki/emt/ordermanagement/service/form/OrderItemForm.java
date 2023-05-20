package mk.ukim.finki.emt.ordermanagement.service.form;

import lombok.Data;
import lombok.Getter;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Grocery;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
public class OrderItemForm {

    @NotNull
    private Grocery grocery;
    @Min(1)
    @NotNull
    private Integer quantity = 1;

}
