package com.learning.mockito.mockitodemo;

public class SomeBusinessImpl {

    private final DataService dataService;

    public SomeBusinessImpl(final DataService dataService) {
        this.dataService = dataService;
    }

    public int findGreatestData() {
        int[] values = dataService.retrieveAllData();
        int greatestValue = Integer.MIN_VALUE;
        for (int value : values) {
            if (value > greatestValue) {
                greatestValue = value;
            }
        }
        return greatestValue;
    }
}
interface DataService {
    int[] retrieveAllData();
}
