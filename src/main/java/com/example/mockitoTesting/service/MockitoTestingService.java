package com.example.mockitoTesting.service;

import com.example.mockitoTesting.model.MockitoTestingModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MockitoTestingService {

    private ArrayList<MockitoTestingModel> modelList = new ArrayList<MockitoTestingModel>();
    private long modelId = 0;

    public ArrayList<MockitoTestingModel> getModelList(){
        return this.modelList;
    }

    public MockitoTestingModel createModel(MockitoTestingModel model){
        model.setModelId(modelId+=1);
        model.setModelStatus("CREATED");
        this.modelList.add(model);
        return model;
    }

    public MockitoTestingModel getModelByModelId(long modelId){
        return modelList.stream()
                .filter(model -> model.getModelId().equals(modelId))
                .findFirst()
                .orElse(null);
    }

    public MockitoTestingModel updateModel(long modelId, MockitoTestingModel model){
        MockitoTestingModel modelToUpdate = modelList.stream()
                .filter(modelTo -> model.getModelId().equals(modelId))
                .findFirst()
                .orElse(null);
        if(modelToUpdate != null){
            modelToUpdate.setModelName(model.getModelName());
            modelToUpdate.setModelStatus(model.getModelStatus());
        }

        return modelToUpdate;
    }
}
