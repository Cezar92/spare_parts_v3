package com.example.spare_parts.service;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.EnginePartsEntity;
import com.example.spare_parts.repository.EnginePartsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class EnginePartsService {
    private final EnginePartsRepository enginePartsRepository;

    public EnginePartsEntity getEnginePart(Integer engineId) {
        return enginePartsRepository.findById(engineId).get();
    }


    public void deleteEnginePart(Integer engineId) {
        enginePartsRepository.deleteById(engineId);
    }

    public EnginePartsEntity findEnginePartById(Integer id){
        return enginePartsRepository.findById(id).orElseThrow(null);   }


    public EnginePartsEntity addNewEnginePart (EnginePartsEntity newEnginePart){
        return enginePartsRepository.save(newEnginePart);
    }
}
