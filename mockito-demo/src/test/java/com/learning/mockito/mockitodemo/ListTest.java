package com.learning.mockito.mockitodemo;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    void test() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(3);
        assertEquals(3, listMock.size());
    }

    @Test
    void multipleReturns() {
        List listMock = mock(List.class);
        when(listMock.size()).thenReturn(1).thenReturn(2);
        assertEquals(1, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    void parameters() {
        List mockList = mock(List.class);
        when(mockList.get(anyInt())).thenReturn("entry");
        assertEquals("entry", mockList.get(0));
        assertEquals("entry", mockList.get(1));
        assertEquals("entry", mockList.get(2));
    }
}
