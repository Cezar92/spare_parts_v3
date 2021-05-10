package com.example.spare_parts.service;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.OrderCreationRequest;
import com.example.spare_parts.entity.OrderEntity;
import com.example.spare_parts.repository.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Data
@Service
@AllArgsConstructor
public class OrderService {
    private final OrderRepository orderRepository;
    private final BrakePartsRepository brakePartsRepository;
    private final EnginePartsRepository enginePartsRepository;
    private final SuspensionPartsRepository suspensionPartsRepository;
    private final UserRepository userRepository;

    public OrderEntity createOrderUsingCustomRequestObject(OrderCreationRequest orderCreationRequest) {

        var userEntity = userRepository.findById(orderCreationRequest.getUserId()).get();
        var engineParts = enginePartsRepository.findAllById(orderCreationRequest.getEnginePartsList());
        var brakeParts = brakePartsRepository.findAllById(orderCreationRequest.getBrakePartsList());
        var suspensionPart = suspensionPartsRepository.findAllById(orderCreationRequest.getSuspensionPartsList());


        OrderEntity orderEntity = OrderEntity.builder()
                .date(LocalDateTime.now())
                .userEntity(userEntity)
                .enginePartsList(engineParts)
                .brakesPartsList(brakeParts)
                .suspensionPartsList(suspensionPart)
                .build();


        engineParts.forEach(engineparts -> engineparts.setOrderEntity(orderEntity));


        return orderRepository.save(orderEntity);

    }



    public OrderEntity getOrder(Integer orderId) {
        return orderRepository.findById(orderId).get();
    }

    public void deleteOrder(Integer orderId) {
        orderRepository.deleteById(orderId);
    }

    public OrderEntity findOrderById(Integer id){
        return orderRepository.findById(id).orElseThrow(null);   }


    public OrderEntity addNewOrder (OrderEntity newOrder){
        return orderRepository.save(newOrder);
    }
}
