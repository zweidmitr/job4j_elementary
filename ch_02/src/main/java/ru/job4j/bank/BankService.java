package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> emptyList = new ArrayList<>();
        users.putIfAbsent(user, emptyList);
    }

    public void addAccount(String passport, Account account) {
        User balvance = findByPassport(passport);
        if (balvance != null) {
            List<Account> oneUser = users.get(balvance);
            if (!oneUser.contains(account)) {
                oneUser.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    public Account findByRequisite(String passport, String requisite) {
        User balvance = findByPassport(passport);
        if (balvance != null) {
            List<Account> usus = users.get(balvance);
            for (Account us : usus) {
                if (us.getRequisite().equals(requisite)) {
                    return us;
                }
            }
        }

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account oAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (oAccount.getBalance() < amount || oAccount == null || destAccount == null) {
            return false;
        }
        oAccount.setBalance(oAccount.getBalance() - amount);
        destAccount.setBalance((destAccount.getBalance()) + amount);
        return true;
    }
}

