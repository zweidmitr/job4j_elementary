package ru.job4j.tracker;

import org.junit.Test;

import java.lang.annotation.Native;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator() + "0. Exit program" + System.lineSeparator()));
    }

//    @Test
//    public void whenCreateItem() {
//        Input in = new StubInput(new String[]{"0", "testItem", "1"});
//        Tracker tracker = new Tracker();
//        UserAction[] actions = {new CreateAction(), new ExitProgramAction()};
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findAll()[0].getName(), is("testItem"));
//
//    }
//
//    @Test
//    public void whenReplaceItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Replaced item"));
//        String replacedName = "new Item Name";
//        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
//        UserAction[] actions = {new ReplaceItemAction(), new ExitProgramAction()};
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
//    }
//
//    @Test
//    public void whenDeleteItem() {
//        Tracker tracker = new Tracker();
//        Item item = tracker.add(new Item("Deleted item"));
//        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
//        UserAction[] actions = {new DeleteItemAction(), new ExitProgramAction()};
//        new StartUI().init(in, tracker, actions);
//        assertThat(tracker.findById(item.getId()), is(nullValue()));
//    }
}