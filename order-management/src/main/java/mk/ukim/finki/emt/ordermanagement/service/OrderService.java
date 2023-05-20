package mk.ukim.finki.emt.ordermanagement.service;

import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderIdDoesNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.exceptions.OrderItemIdDoesNotExistException;
import mk.ukim.finki.emt.ordermanagement.domain.model.Order;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderId;
import mk.ukim.finki.emt.ordermanagement.domain.model.OrderItemId;
import mk.ukim.finki.emt.ordermanagement.service.form.OrderForm;
import mk.ukim.finki.emt.ordermanagement.service.form.OrderItemForm;

import java.util.List;
import java.util.Optional;

public interface OrderService {
    OrderId placeOrder(OrderForm orderForm);
    List<Order> findAll();
    Optional<Order> findById(OrderId orderId);
    void addItem(OrderId orderId, OrderItemForm orderItemForm) throws OrderIdDoesNotExistException;
    void deleteItem(OrderId orderId, OrderItemId orderItemId) throws OrderIdDoesNotExistException,
            OrderItemIdDoesNotExistException;
}
