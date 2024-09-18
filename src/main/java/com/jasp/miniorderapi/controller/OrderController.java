package com.jasp.miniorderapi.controller;

import com.jasp.miniorderapi.dto.OrderRequestDto;
import com.jasp.miniorderapi.entity.Orders;
import com.jasp.miniorderapi.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @ResponseBody
    @GetMapping("/order")
    public ResponseEntity<?> read(){
        List<Orders> result = orderService.getAllOrderList();
        return ResponseEntity.ok().body(result);
    }

    @ResponseBody
    @PostMapping("/order")
    public ResponseEntity<?> create(@RequestBody OrderRequestDto orderDto){
        orderService.save(orderDto);
        return ResponseEntity.ok().build();
    }

    @PutMapping("/order/{orderId}")
    public ResponseEntity<?> update(@PathVariable Integer orderId, @RequestBody OrderRequestDto orderDto){
        orderService.update(orderId, orderDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/order/{orderId}")
    public ResponseEntity<?> delete(@PathVariable Integer orderId){
        orderService.remove(orderId);
        return ResponseEntity.ok().build();
    }
}
