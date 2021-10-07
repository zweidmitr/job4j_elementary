package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class ProfilesTest {

    @Test
    public void collect() {
        List<Profile> profilesList = new ArrayList<>();
        profilesList.add(new Profile(new Address("msk", "red", 99, 2)));
        profilesList.add(new Profile(new Address("spb", "neva", 25, 12)));
        Profiles pr = new Profiles();
        String result = pr.collect(profilesList).get(1).getStreet();
        assertThat(result, is("neva"));

    }
}