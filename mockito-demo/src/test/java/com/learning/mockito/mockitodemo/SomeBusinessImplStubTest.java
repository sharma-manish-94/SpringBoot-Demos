package com.learning.mockito.mockitodemo;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SomeBusinessImplStubTest {
    @Test
    void test() {
        DataService stub = new DataServiceStub();
        SomeBusinessImpl someBusiness = new SomeBusinessImpl(stub);
        int result = someBusiness.findGreatestData();
        assertEquals(4, result);
    }
}

class DataServiceStub implements DataService {
    @Override
    public int[] retrieveAllData() {
        return new int[]{1, 2, 3, 4};
    }
}


