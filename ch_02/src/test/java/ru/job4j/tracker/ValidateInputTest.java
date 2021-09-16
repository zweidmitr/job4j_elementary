package ru.job4j.tracker;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;

public class ValidateInputTest {

    @Test
    public void whenInvalidInput() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"one", "1"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter menu: ");
        assertThat(selected, is(1));
    }

    @Test
    public void whenValidInputOne() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"2"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter: ");
        assertThat(selected, is(2));
    }

    @Test
    public void whenValidInputTwo() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"9", "55"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("Enter: ");
        assertThat(selected, is(9));
    }

    @Test
    public void whenInvalidMinus() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"-1", "5"});
        ValidateInput input = new ValidateInput(out, in);
        int selected = input.askInt("word");
        assertThat(selected, is(5));
    }
}