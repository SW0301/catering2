package ru.catering.service;

import ru.catering.model.Order;
import ru.catering.repository.OrderRepository;

public class OrderService {

    private final OrderRepository orderRepository;


    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public Long createOrder(Order orderFromClient){
        Order order = new Order();
        order.setDate(orderFromClient.getDate());
        order.setTotalPrice(orderFromClient.getTotalPrice());
        order.setAddress(orderFromClient.getAddress());
        order.setTelephone(orderFromClient.getTelephone());
        order.setStatus(orderFromClient.getStatus());
        order.setUser(orderFromClient.getUser());
        order.setDeleted(false);
        orderRepository.save(order);
        return order.getId();
    }

    public Order getOrder(Long id){
        return orderRepository.getById(id);
    }

    public void deleteOrder(Long id){
        Order order = orderRepository.getById(id);
        order.setDeleted(true);
        orderRepository.save(order);
    }
}
