package com.example.spare_parts.controller;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.OrderEntity;
import com.example.spare_parts.entity.UserEntity;
import com.example.spare_parts.repository.BrakePartsRepository;
import com.example.spare_parts.service.BrakePartsService;
import lombok.RequiredArgsConstructor;

import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class BrakePartsController {
    private final BrakePartsService brakePartsService;
    private final BrakePartsRepository brakePartsRepository;

    @GetMapping(value = "/brakeParts") // show all parts
    public List<BrakePartsEntity> getBrakePart() {
        return brakePartsRepository.findAll();
    }


    @GetMapping("/brakeParts/{id}") //show part by id
    public BrakePartsEntity findBrakePartById(@PathVariable("id")Integer id){
        return brakePartsService.findBrakePartById(id);
    }

    @PostMapping("/brakeParts/{id}") // update part by id
    public BrakePartsEntity updateBrakePartsById(@PathVariable("id")Integer id, @RequestBody @Validated BrakePartsEntity brakePartsEntity){
        return brakePartsService.addNewBrakePart(brakePartsEntity);
    }
//   Create parts ///
    @PostMapping(value="/brakeParts/create", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public BrakePartsEntity createBrakePart(@RequestBody @Validated BrakePartsEntity brakePartsEntity){
        return brakePartsService.addNewBrakePart(brakePartsEntity);
    }

    @DeleteMapping("/brakePart/{brakePartId}")  // Delete part
    public void deleteBrakePart(@PathVariable(name = "brakePartId")Integer id){
        brakePartsService.deleteBrakePart(id);
    }

}

