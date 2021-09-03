package ru.job4j.condition;

import org.junit.Test;
import org.junit.Assert;

public class X2Test {

    @Test
    public void whenA10B0C0X2Then40() {
        /* входные параметры */
        int a = 10;
        int b = 0;
        int c = 0;
        int x = 2;
        /* ожидаемое значение, это всегда одна переменная */
        int expected = 40;
        /* вызов метода, который хотим проверить */
        /* результат вычисления это  всегда одна переменная */
        int rsl = X2.calc(a, b, c, x);
        /* сравнение полученного значения с ожиданием */
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenA1B1C1X1Then3() {
        /* входные параметры */
        int a = 1;
        int b = 1;
        int c = 1;
        int x = 1;
        /* ожидаемое значение, это всегда одна переменная */
        int expected = 3;
        /* вызов метода, который хотим проверить */
        /* результат вычисления это  всегда одна переменная */
        int rsl = X2.calc(a, b, c, x);
        /* сравнение полученного значения с ожиданием */
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenA0B1C1X1Then2() {
        /* входные параметры */
        int a = 0;
        int b = 1;
        int c = 1;
        int x = 1;
        /* ожидаемое значение, это всегда одна переменная */
        int expected = 2;
        /* вызов метода, который хотим проверить */
        /* результат вычисления это  всегда одна переменная */
        int rsl = X2.calc(a, b, c, x);
        /* сравнение полученного значения с ожиданием */
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenA1B1C0X1Then2() {
        /* входные параметры */
        int a = 1;
        int b = 1;
        int c = 0;
        int x = 1;
        /* ожидаемое значение, это всегда одна переменная */
        int expected = 2;
        /* вызов метода, который хотим проверить */
        /* результат вычисления это  всегда одна переменная */
        int rsl = X2.calc(a, b, c, x);
        /* сравнение полученного значения с ожиданием */
        Assert.assertEquals(rsl, expected);
    }

    @Test
    public void whenA1B1C1X0Then1() {
        /* входные параметры */
        int a = 1;
        int b = 1;
        int c = 1;
        int x = 0;
        /* ожидаемое значение, это всегда одна переменная */
        int expected = 1;
        /* вызов метода, который хотим проверить */
        /* результат вычисления это  всегда одна переменная */
        int rsl = X2.calc(a, b, c, x);
        /* сравнение полученного значения с ожиданием */
        Assert.assertEquals(rsl, expected);
    }

}