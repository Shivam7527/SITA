package com.sshukla7527.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.sshukla7527.demo.entity.Order;
import com.sshukla7527.demo.entity.User;
import com.sshukla7527.demo.repository.OrderNotFoundException;
import com.sshukla7527.demo.repository.OrderRepository;

@Service
public class OrderService {
    @Autowired private OrderRepository repository;
    @Autowired private RestTemplate restTemplate;

    public Order create(Order order) {
        try {
            restTemplate.getForObject("http://localhost:8080/app/" + order.getUserId(), User.class);
        } catch (HttpClientErrorException.NotFound ex) {
            throw new OrderNotFoundException("User does not exist for order");
        }
        return repository.save(order);
    }
    public Order getById(Long id) {
        return repository.findById(id).orElseThrow(() -> new OrderNotFoundException("Order not found"));
    }
    public Order update(Long id, Order order) {
        Order existing = getById(id);
        existing.setProduct(order.getProduct());
        existing.setQuantity(order.getQuantity());
        existing.setPrice(order.getPrice());
        return repository.save(existing);
    }
    public void delete(Long id) {
        repository.delete(getById(id));
    }
}
