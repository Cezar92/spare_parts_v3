package com.example.spare_parts.controller;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.SuspensionPartsEntity;
import com.example.spare_parts.repository.BrakePartsRepository;
import com.example.spare_parts.repository.SuspensionPartsRepository;
import com.example.spare_parts.service.BrakePartsService;
import com.example.spare_parts.service.SuspensionPartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class SuspensionPartController {
    private final SuspensionPartsService suspensionPartsService;
    private final SuspensionPartsRepository suspensionPartsRepository;

    @GetMapping(value = "/suspensionParts") // show all parts
    public List<SuspensionPartsEntity> getSuspensionPart() {
        return suspensionPartsRepository.findAll();
    }


    @GetMapping("/suspensionParts/{id}") //show part by id
    public SuspensionPartsEntity findSuspensionPartById(@PathVariable("id")Integer id){
        return suspensionPartsService.findSuspensionPartById(id);
    }

    @PostMapping("/suspensionParts/{id}") // update part by id
    public SuspensionPartsEntity updateSuspensionPartsById(@PathVariable("id")Integer id, @RequestBody @Validated SuspensionPartsEntity suspensionPartsEntity){
        return suspensionPartsService.addNewSuspensionPart(suspensionPartsEntity);
    }
    //   Create parts ///
    @PostMapping(value="/suspensionParts/create", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public SuspensionPartsEntity createSuspensionPart(@RequestBody @Validated SuspensionPartsEntity suspensionPartsEntity){
        return suspensionPartsService.addNewSuspensionPart(suspensionPartsEntity);
    }

    @DeleteMapping("/suspensionPart/{suspensionPartId}")  // Delete part
    public void deleteSuspensionPart(@PathVariable(name = "suspensionPartId")Integer id){
        suspensionPartsService.deleteSuspensionPart(id);
    }

}
