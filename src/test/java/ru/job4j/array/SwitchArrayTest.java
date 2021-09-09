package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SwitchArrayTest {

    @Test
    public void whenSwap0to3() {
        int[] input = {1, 2, 3, 4};
        int source = 0;
        int dest = input.length - 1;
        int[] result = SwitchArray.swap(input, source, dest);
        int[] expected = {4, 2, 3, 1};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenSwap8to9() {
        int[] input = {99, 98, 97, 96, 95, 94, 93, 92, 91, 90};
        int source = 8;
        int dest = input.length - 1;
        int[] result = SwitchArray.swap(input, source, dest);
        int[] expected = {99, 98, 97, 96, 95, 94, 93, 92, 90, 91};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenSwap2to4() {
        int[] input = {1, 2, 1, 2, 3};
        int source = 2;
        int dest = input.length - 1;
        int[] result = SwitchArray.swap(input, source, dest);
        int[] expected = {1, 2, 3, 2, 1};
        Assert.assertArrayEquals(expected, result);
    }
}