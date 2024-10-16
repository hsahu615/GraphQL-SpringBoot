package com.graphql.demo.controllers;

import com.graphql.demo.models.Order;
import com.graphql.demo.models.User;
import com.graphql.demo.services.OrderService;
import com.graphql.demo.services.UserService;
import org.aspectj.weaver.ast.Or;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class UserController {
    private UserService userService;
    private OrderService orderService;

    public UserController(UserService userService, OrderService orderService){
        this.userService = userService;
        this.orderService = orderService;
    }

    @MutationMapping
    public User createUser(@Argument String name, @Argument String email, @Argument String password) {
        User user = new User();
        user.setEmail(email);
        user.setName(name);
        user.setPassword(password);
        return this.userService.createUser(user);
    }

    @QueryMapping
    public List<User> getUsers() {
        return this.userService.getAllUsers();
    }

    @QueryMapping
    public User getUser(@Argument Integer userId) {
        return this.userService.getUser(userId);
    }

    @MutationMapping
    public Boolean deleteUser(@Argument Integer userId) {
        return this.userService.deleteUser(userId);
    }

    @MutationMapping
    public Order createOrder(@Argument String description, @Argument String address, @Argument Integer price, @Argument Integer userId) {
        User user = userService.getUser(userId);
        Order order = new Order();
        order.setUser(user);
        order.setAddress(address);
        order.setPrice(price);
        order.setDescription(description);
        return this.orderService.createOrder(order);
    }

    @QueryMapping
    public List<Order> getOrders() {
        return this.orderService.getAllOrder();
    }

    @MutationMapping
    public Boolean deleteOrder(@Argument Integer id) {
        return this.orderService.deleteOrder(id);
    }
}
