package ru.job4j.stream;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        List<Address> result = profiles.stream()
                .map(Profile::getAddress)
                .sorted((x, y) -> x.getCity().compareTo(y.getCity()))
                .distinct()
                .collect(Collectors.toList());
        result.forEach(System.out::println);
        return result;
    }
}
