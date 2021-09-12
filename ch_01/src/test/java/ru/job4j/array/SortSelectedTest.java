package ru.job4j.array;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class SortSelectedTest {

    @Test
    public void whenSort() {
        int[] data = new int[]{3, 4, 1, 2, 5};
        int[] result = SortSelected.sort(data);
        int[] expected = new int[]{1, 2, 3, 4, 5};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenSort3() {
        int[] data = new int[]{84, 73, 52};
        int[] result = SortSelected.sort(data);
        int[] expected = new int[]{52, 73, 84};
        Assert.assertArrayEquals(expected, result);
    }

    @Test
    public void whenSort5() {
        int[] data = new int[]{999, 666, 777, 333, 111};
        int[] result = SortSelected.sort(data);
        int[] expected = new int[]{111, 333, 666, 777, 999};
        Assert.assertArrayEquals(expected, result);
    }
}