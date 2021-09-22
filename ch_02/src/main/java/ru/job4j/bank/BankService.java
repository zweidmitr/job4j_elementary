package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает банковский сервис
 *
 * @author Дмитрий
 * @version 1.0
 */

public class BankService {
    /**
     * поле содержит всех пользователей системы с привязанными к ним счетами
     * Хранение осуществляется в коллекции типа HashMap
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * метод должен добавить пользователя в систему
     *
     * @param user пользователь который добавляется в систему
     */
    public void addUser(User user) {
        List<Account> emptyList = new ArrayList<>();
        users.putIfAbsent(user, emptyList);
    }

    /**
     * метод добавляет новый счет, на основании данных паспорта
     * находит пользователя и проверяет есть ли у него уже такой счет
     *
     * @param passport данные паспорта
     * @param account  счет который необходимо проверить
     */
    public void addAccount(String passport, Account account) {
        User balvance = findByPassport(passport);
        if (balvance != null) {
            List<Account> oneUser = users.get(balvance);
            if (!oneUser.contains(account)) {
                oneUser.add(account);
            }
        }
    }

    /**
     * Метод находит по данным паспорта пользователя и возвращает его
     *
     * @param passport данные паспорта
     * @return пользователь
     */
    public User findByPassport(String passport) {
        for (User key : users.keySet()) {
            if (key.getPassport().equals(passport)) {
                return key;
            }
        }
        return null;
    }

    /**
     * Метод ищет счет пользователя по реквизитам
     *
     * @param passport  данные паспорта
     * @param requisite реквизиты аккаунта
     * @return возвращает счет пользователя
     */
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

    /**
     * метод пердназначен для перечисления денег с одного счета на другой
     * так же есть проверка, на то чтобы деньги на счете были и пользователь не ушел в минус
     *
     * @param srcPassport   данные паспорта, пользователя со счета которого произойдет отправка
     * @param srcRequisite  номер счета, с которого произойдет отправка
     * @param destPassport  данные паспорта получателя
     * @param destRequisite номер счета на который пройдет перечисление
     * @param amount        сумма, которую необходимо перевести
     * @return возвращает признак успешного проведения операции
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        Account oAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (oAccount == null || destAccount == null || oAccount.getBalance() < amount) {
            return false;
        }
        oAccount.setBalance(oAccount.getBalance() - amount);
        destAccount.setBalance((destAccount.getBalance()) + amount);
        return true;
    }
}

