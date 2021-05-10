package com.example.spare_parts.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "engineparts")
public class EnginePartsEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "engine_id")
    private Integer id;

//    @Column(name = "name")
    private String name;

//    @Column(name = "price")
    private double price;

    @Column(name = "pieces")
    private int quantity;

    @ManyToOne
    @JoinColumn(name= "order_id")
    private OrderEntity orderEntity;
}
