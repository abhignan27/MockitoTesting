package com.example.mockitoTesting.model;

import java.util.Objects;

public class MockitoTestingModel {

    private Long modelId;
    private String modelName;
    private String modelStatus;

    public MockitoTestingModel(Long id, String name){
        this.modelId = id;
        this.modelName = name;
        this.modelStatus = "CREATED";
    }
    public Long getModelId() {
        return this.modelId;
    }

    public void setModelId(long modelId) {
        this.modelId = modelId;
    }

    public String getModelName() {
        return this.modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public String getModelStatus() {
        return this.modelStatus;
    }

    public void setModelStatus(String modelStatus) {
        this.modelStatus = modelStatus;
    }
}
