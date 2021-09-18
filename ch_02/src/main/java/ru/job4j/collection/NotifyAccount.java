package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        Account temp = new Account("test", "test", "test");
        for (Account acco : accounts) {
            if (!acco.equals(temp)) {
                temp = acco;
                rsl.add(acco);
            }
        }
        return rsl;
    }
}
