package com.example.spare_parts.service;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.SuspensionPartsEntity;
import com.example.spare_parts.repository.SuspensionPartsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class SuspensionPartsService {
    private final SuspensionPartsRepository suspensionPartsRepository;

    public SuspensionPartsEntity getSuspensionPart(Integer suspensionId) {

        return suspensionPartsRepository.findById(suspensionId).get();
    }

    public void deleteSuspensionPart(Integer suspensionId) {
        suspensionPartsRepository.deleteById(suspensionId);
    }
//
    public SuspensionPartsEntity findSuspensionPartById(Integer id){
        return suspensionPartsRepository.findById(id).orElseThrow(null);   }
//
//
    public SuspensionPartsEntity addNewSuspensionPart (SuspensionPartsEntity newSuspensionPart){
        return suspensionPartsRepository.save(newSuspensionPart);
    }
}
