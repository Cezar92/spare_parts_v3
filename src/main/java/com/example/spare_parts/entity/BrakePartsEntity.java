package com.example.spare_parts.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Data
@Table(name = "brakesparts")
public class BrakePartsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "brake_id")
    private Integer id;

    @Column(name = "partname")
    private String name;

//    @Column(name = "price")
    private double price;

    @Column(name = "pieces")
    private int quantity;

    @ManyToOne
    @JoinColumn(name= "order_id")
    private OrderEntity orderEntity;



}
