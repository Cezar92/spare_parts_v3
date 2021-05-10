package com.example.spare_parts.repository;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.EnginePartsEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EnginePartsRepository extends JpaRepository<EnginePartsEntity, Integer> {
}
