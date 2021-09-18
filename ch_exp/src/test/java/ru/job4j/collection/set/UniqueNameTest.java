package ru.job4j.collection.set;

import org.junit.Test;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static ru.job4j.collection.set.UniqueName.User;

import static org.junit.Assert.*;

public class UniqueNameTest {

    @Test
    public void collectUniqueName() {
        List<User> users = List.of(
                new User(1, "name1"),
                new User(2, "name2"),
                new User(3, "name1"),
                new User(4, "name3"),
                new User(5, "name5"),
                new User(6, "name3")
        );
        int rsl = UniqueName.collectUniqueName(users);
        int expected = 4;
        assertThat(rsl, is(expected));
    }
}