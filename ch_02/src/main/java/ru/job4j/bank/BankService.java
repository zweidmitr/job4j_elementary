package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private final Map<User, List<Account>> users = new HashMap<>();

    public void addUser(User user) {
        List<Account> emptyList = new ArrayList<>();
        if (!users.containsKey(user)) {
            users.put(user, emptyList);
        }
    }

    public void addAccount(String passport, Account account) {
        User balvance = findByPassport(passport);
        boolean temp = true;
        if (balvance != null) {
            List<Account> oneUser = users.get(balvance);
            if (!oneUser.isEmpty()) {
                for (Account us : oneUser) {
                    if (us.equals(account)) {
                        temp = false;
                    }
                }
            }
            if (temp) {
                oneUser.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        for (Map.Entry<User, List<Account>> entry : users.entrySet()) {
            User key = entry.getKey();
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
            if (usus.isEmpty()) {
                return null;
            } else {
                for (Account us : usus) {
                    if (us.getRequisite().equals(requisite)) {
                        return us;
                    }
                }
            }
        }

        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account oAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (oAccount.getBalance() < amount) {
            return false;
        }
        oAccount.setBalance(oAccount.getBalance() - amount);
        destAccount.setBalance((destAccount.getBalance()) + amount);
        return true;
    }
}

