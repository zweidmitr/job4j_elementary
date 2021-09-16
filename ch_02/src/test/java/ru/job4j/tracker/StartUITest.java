package ru.job4j.tracker;

import org.junit.Test;

import java.lang.annotation.Native;
import java.time.format.DateTimeFormatter;

import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class StartUITest {
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"15", "1", "0"});
        Tracker tracker = new Tracker();
        UserAction[] action = new UserAction[]{new ShowAllItemAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, action);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu: " + ln
                        + "0. Show all item" + ln
                        + "1. Exit program" + ln
                        + "Wrong input!! You can select: 0 .. 0" + ln
                        + "Menu: " + ln
                        + "0. Show all item" + ln
                        + "1. Exit program" + ln
                )
        );

    }

    @Test
    public void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator() + "0. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllNull() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new ShowAllItemAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "Хранилище еще не содержит заявок" + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindAllOneItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testik"));
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "1"});
        UserAction[] actions = {new ShowAllItemAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Show all item" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testik"));
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getName()), "1"});
        UserAction[] actions = {new FindByNameAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find by name ===" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Find items by name" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenFindById() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("testik"));
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new FindByIdAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is("Menu: " + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()
                + "=== Find item by id ===" + System.lineSeparator()
                + item.toString() + System.lineSeparator()
                + "Menu: " + System.lineSeparator()
                + "0. Find item by id" + System.lineSeparator()
                + "1. Exit program" + System.lineSeparator()));
    }

    @Test
    public void whenCreateItem() {
        Output out = new StubOutput();
        Input in = new StubInput(new String[]{"0", "testItem", "1"});
        Tracker tracker = new Tracker();
        UserAction[] actions = {new CreateAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("testItem"));

    }

    @Test
    public void whenReplaceItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "new Item Name";
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), replacedName, "1"});
        UserAction[] actions = {new ReplaceItemAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Output out = new StubOutput();
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(item.getId()), "1"});
        UserAction[] actions = {new DeleteItemAction(out), new ExitProgramAction()};
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }
}