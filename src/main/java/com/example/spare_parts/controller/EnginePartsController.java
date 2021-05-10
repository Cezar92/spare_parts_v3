package com.example.spare_parts.controller;

import com.example.spare_parts.entity.BrakePartsEntity;
import com.example.spare_parts.entity.EnginePartsEntity;
import com.example.spare_parts.repository.EnginePartsRepository;
import com.example.spare_parts.service.EnginePartsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/")
public class EnginePartsController {
    private final EnginePartsService enginePartsService;
    private final EnginePartsRepository enginePartsRepository;

    @GetMapping(value = "/engineParts") // show all parts
    public List<EnginePartsEntity> getEnginePart() {
        return enginePartsRepository.findAll();
    }


    @GetMapping("/engineParts/{id}") //show part by id
    public EnginePartsEntity findEnginePartById(@PathVariable("id")Integer id){
        return enginePartsService.findEnginePartById(id);
    }
//
    @PostMapping("/engineParts/{id}") // update part by id
    public EnginePartsEntity updateEnginePartsById(@PathVariable("id")Integer id, @RequestBody @Validated EnginePartsEntity enginePartsEntity){
        return enginePartsService.addNewEnginePart(enginePartsEntity);
    }
//    //   Create parts ///
    @PostMapping(value="/engineParts/create", consumes = "application/json", produces = MediaType.APPLICATION_JSON_VALUE)
    public EnginePartsEntity createEnginePart(@RequestBody @Validated EnginePartsEntity enginePartsEntity){
        return enginePartsService.addNewEnginePart(enginePartsEntity);
    }

    @DeleteMapping("/enginePart/{enginePartId}")  // Delete part
    public void deleteEnginePart(@PathVariable(name = "enginePartId")Integer id){
        enginePartsService.deleteEnginePart(id);
    }
}
