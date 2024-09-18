package com.jasp.miniorderapi.service;

import com.jasp.miniorderapi.category.Category;
import com.jasp.miniorderapi.dto.OrderRequestDto;
import com.jasp.miniorderapi.entity.Orders;
import com.jasp.miniorderapi.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;

    // Order 저장
    public void save(OrderRequestDto orderRequestDto) {
        String name = orderRequestDto.getName();
        Category category = orderRequestDto.getCategory();
        LocalDateTime dateTime = orderRequestDto.getDateTime();
        int amount = orderRequestDto.getAmount();

        Orders order = new Orders(name, category, dateTime, amount);
        orderRepository.save(order);
    }

    public List<Orders> getAllOrderList(){
        return orderRepository.findAll();
    }

    public void update(Integer orderId, OrderRequestDto requestDto){
        Orders order = orderRepository.findById(orderId).get();
        order.setName(requestDto.getName());
        order.setCategory(requestDto.getCategory());
    }

    public void remove(Integer orderId){
        orderRepository.deleteById(orderId);
    }
}
