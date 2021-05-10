package com.example.spare_parts.entity;

import lombok.Data;

import java.util.List;

@Data
public class OrderCreationRequest {

    List<Integer> brakePartsList;
    List<Integer> enginePartsList;
    List<Integer> suspensionPartsList;
    private Integer userId;

}
