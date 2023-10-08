package com.example.mockitoTesting;

import com.example.mockitoTesting.model.MockitoTestingModel;
import com.example.mockitoTesting.service.MockitoTestingService;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;

public class MockitoTestingServiceTest {


    MockitoTestingService mockitoTestingService = mock(MockitoTestingService.class);

    @Test
    public void getAllModels(){
        ArrayList<MockitoTestingModel> modelArrayList = new ArrayList();
        modelArrayList.add(new MockitoTestingModel(1L, "Model 1"));
        modelArrayList.add(new MockitoTestingModel(2L, "Model 2"));

        Mockito.when(mockitoTestingService.getModelList()).thenReturn(modelArrayList);

        ArrayList<MockitoTestingModel> results = mockitoTestingService.getModelList();

        assertEquals(modelArrayList, results);
        assertEquals(2, results.size());

        Mockito.verify(mockitoTestingService, Mockito.times(1)).getModelList();
    }

    @Test
    public void getModelByModelId(){
        MockitoTestingModel model = new MockitoTestingModel(1L, "Model 1");

        Mockito.when(mockitoTestingService.getModelByModelId(anyLong())).thenReturn(model);
        MockitoTestingModel result = mockitoTestingService.getModelByModelId(anyLong());

        assertEquals(model, result);

        Mockito.verify(mockitoTestingService, times(1)).getModelByModelId(anyLong());
    }
}
