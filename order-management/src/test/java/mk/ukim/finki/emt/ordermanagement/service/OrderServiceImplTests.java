package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Grocery;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.GroceryId;
import mk.ukim.finki.emt.ordermanagement.service.form.OrderForm;
import mk.ukim.finki.emt.ordermanagement.service.form.OrderItemForm;
import mk.ukim.finki.emt.ordermanagement.xport.client.GroceryClient;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.MeasurementUnit;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.NutritionalValue;
import mk.ukim.finki.emt.sharedkernel.domain.nutritional.Quantity;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdDoesNotExistException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

@SpringBootTest
public class OrderServiceImplTests {

    @Autowired
    private OrderService orderService;

    @Autowired
    private GroceryClient groceryClient;

    private static Grocery newGrocery(String name, Money price) {
        return new Grocery(
                GroceryId.randomId(GroceryId.class),
                name,
                name + "...",
                NutritionalValue.of(10., 25., 5., 150.),
                Quantity.of(10, MeasurementUnit.KILOGRAMS),
                100,
                price);
    }

    @Test
    public void testPlaceOrder() {
        OrderItemForm oi1 = new OrderItemForm();
        oi1.setGrocery(newGrocery("Pizza", Money.valueOf(Currency.MKD, 800.)));
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setGrocery(newGrocery("Hot Dog", Money.valueOf(Currency.MKD, 100.)));
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1, oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdDoesNotExistException::new);
        Assertions.assertEquals(newOrder.total(), Money.valueOf(Currency.MKD, 1000.));
    }

    @Test
    public void testPlaceOrderWithRealData() {
        List<Grocery> groceryList = groceryClient.findAll();
        Grocery grocery1 = groceryList.get(0);
        Grocery grocery2 = groceryList.get(1);

        OrderItemForm oi1 = new OrderItemForm();
        oi1.setGrocery(grocery1);
        oi1.setQuantity(1);

        OrderItemForm oi2 = new OrderItemForm();
        oi2.setGrocery(grocery2);
        oi2.setQuantity(2);

        OrderForm orderForm = new OrderForm();
        orderForm.setCurrency(Currency.MKD);
        orderForm.setItems(Arrays.asList(oi1, oi2));

        OrderId newOrderId = orderService.placeOrder(orderForm);
        Order newOrder = orderService.findById(newOrderId).orElseThrow(OrderIdDoesNotExistException::new);

        Money outMoney = grocery1.getPrice().multiply(oi1.getQuantity()).add(grocery2.getPrice().multiply(oi2.getQuantity()));
        Assertions.assertEquals(newOrder.total(), outMoney);
    }

}