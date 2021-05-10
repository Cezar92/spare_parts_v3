package com.example.spare_parts.repository;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.OrderEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrakePartsRepository extends JpaRepository <BrakePartsEntity, Integer> {
//    @Query
//    List<BrakePartsEntity>findAllById(int id);
}
