package com.example.mockitoTesting.controller;

import com.example.mockitoTesting.model.MockitoTestingModel;
import com.example.mockitoTesting.service.MockitoTestingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class MockitoTestingController {

    @Autowired
    private MockitoTestingService mockitoTestingService;

    @GetMapping("/modelList")
    public ArrayList<MockitoTestingModel> getAllModels(){
        return mockitoTestingService.getModelList();
    }

    @PostMapping("/createModel")
    public MockitoTestingModel createModel(@RequestBody MockitoTestingModel model){
        return mockitoTestingService.createModel(model);
    }

    @GetMapping("/getModelByModelId/{id}")
    public MockitoTestingModel getModelByModelId(@PathVariable long id){
        return mockitoTestingService.getModelByModelId(id);
    }

    @PutMapping("/{id}")
    public MockitoTestingModel updateModel(@PathVariable Long id, @RequestBody MockitoTestingModel model){
        return mockitoTestingService.updateModel(id, model);
    }
}
