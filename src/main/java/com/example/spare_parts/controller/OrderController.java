package com.example.spare_parts.controller;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.OrderCreationRequest;
import com.example.spare_parts.entity.OrderEntity;
import com.example.spare_parts.repository.BrakePartsRepository;
import com.example.spare_parts.repository.OrderRepository;
import com.example.spare_parts.service.BrakePartsService;
import com.example.spare_parts.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class OrderController {
    private final OrderService orderService;
    private final OrderRepository orderRepository;

    @GetMapping(value = "/order") // show all orders
    public List<OrderEntity> getOrder() {
        return orderRepository.findAll();
    }


    @GetMapping("/order/{id}") //show order by id
    public OrderEntity findOrderPartById(@PathVariable("id") Integer id) {
        return orderService.findOrderById(id);
    }

    //
    @PostMapping("/order/{id}") // update order by id
    public OrderEntity updateOrder(@PathVariable("id") Integer id, @RequestBody @Validated OrderEntity orderEntity) {
        return orderService.addNewOrder(orderEntity);
    }

    //   Create order ///
    @PostMapping(value = "/order/create", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderEntity createOrder(@RequestBody @Validated OrderEntity orderEntity) {
        return orderService.addNewOrder(orderEntity);
    }

    //
    @DeleteMapping("/order/{orderId}")  // Delete order
    public void deleteOrder(@PathVariable(name = "orderId") Integer id) {
        orderService.deleteOrder(id);
    }

    @PostMapping(value = "/invoice/createUsingRightRequest", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public OrderEntity orderEntity(@RequestBody @Validated OrderCreationRequest orderCreationRequest) {

        return orderService.createOrderUsingCustomRequestObject(orderCreationRequest);
    }
}
