package com.example.spare_parts.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "orderr")
public class OrderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "info")
    private String info;

    private LocalDateTime date;

    @ManyToOne
    @JoinColumn(name= "user_id")
    private UserEntity userEntity;

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<BrakePartsEntity> brakesPartsList = new ArrayList<>();

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<SuspensionPartsEntity> suspensionPartsList = new ArrayList<>();

    @OneToMany(mappedBy = "orderEntity", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EnginePartsEntity> enginePartsList = new ArrayList<>();

}
