package com.graphql.demo.services;

import com.graphql.demo.ExceptionHelper;
import com.graphql.demo.models.Order;
import com.graphql.demo.repositories.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo){
        this.orderRepo = orderRepo;
    }

    public Order createOrder(Order order) {
        return this.orderRepo.save(order);
    }

    public List<Order> getAllOrder() {
        return this.orderRepo.findAll();
    }

    public boolean deleteOrder(Integer id) {
        Order order = this.orderRepo.findById(id).orElseThrow(ExceptionHelper::resourceNotFoundException);
        this.orderRepo.delete(order);
        return true;
    }
}