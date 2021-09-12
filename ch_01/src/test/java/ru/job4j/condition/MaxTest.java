package ru.job4j.condition;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class MaxTest {

    @Test
    public void thenMax1To2Then2() {
        int left = 1;
        int right = 2;
        int result = Max.max(left, right);
        int expected = 2;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void thenMax9To7Then9() {
        int left = 9;
        int right = 7;
        int result = Max.max(left, right);
        int expected = 9;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void thenMax4To44Then44() {
        int left = 4;
        int right = 44;
        int result = Max.max(left, right);
        int expected = 44;
        Assert.assertEquals(expected, result);
    }

    @Test
    public void thenMax7To7Then7() {
        int left = 7;
        int right = 7;
        int result = Max.max(left, right);
        int expected = 7;
        Assert.assertEquals(expected, result);
    }
}