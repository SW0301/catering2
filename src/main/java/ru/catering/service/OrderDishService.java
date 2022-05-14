package ru.catering.service;

import org.springframework.stereotype.Service;
import ru.catering.model.OrderDish;
import ru.catering.repository.OrderDishRepository;

@Service
public class OrderDishService {

    private final OrderDishRepository orderDishRepository;

    public OrderDishService(OrderDishRepository orderDishRepository) {
        this.orderDishRepository = orderDishRepository;
    }

    public void setOrderDish(OrderDish orderDishFromAdmin){
        OrderDish orderDish = new OrderDish();
        orderDish.setDish(orderDishFromAdmin.getDish());
        orderDish.setOrder(orderDishFromAdmin.getOrder());
        orderDish.setCook(orderDishFromAdmin.getCook());
        orderDish.setCount(orderDishFromAdmin.getCount());
    }


}
