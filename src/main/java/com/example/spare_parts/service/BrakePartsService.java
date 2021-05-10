package com.example.spare_parts.service;


import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.OrderEntity;

import com.example.spare_parts.entity.UserEntity;
import lombok.AllArgsConstructor;

import org.springframework.stereotype.Service;
import com.example.spare_parts.repository.BrakePartsRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class BrakePartsService {

    private final BrakePartsRepository brakePartsRepository;

    public BrakePartsEntity getBrakePart(Integer brakeId) {

        return brakePartsRepository.findById(brakeId).get();
    }

    public void deleteBrakePart(Integer brakeId) {
        brakePartsRepository.deleteById(brakeId);
    }

    public BrakePartsEntity findBrakePartById(Integer id){
        return brakePartsRepository.findById(id).orElseThrow(null);   }


    public BrakePartsEntity addNewBrakePart (BrakePartsEntity newBrakePart){
        return brakePartsRepository.save(newBrakePart);
    }
}
