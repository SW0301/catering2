package ru.catering.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.catering.model.Order;
import ru.catering.service.OrderService;

@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public void setOrderService(OrderService orderService){
        this.orderService = orderService;}

    @PostMapping(value = "/order/create")
    public void createOrder(@RequestBody Order orderFromAdmin){
        orderService.createOrder(orderFromAdmin);
    }

    @GetMapping(value = "/order/get")
    public Order getOrderById(@RequestParam Long id){return orderService.getOrder(id);}
}
