package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковской системы, которая работает
 * с Map<User, List<Account>>
 * @author  AMAN ABDULAEV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение для пользователей осуществляется в Map<User, List<Account>>
     */

    private Map<User, List<Account>> users = new HashMap<>();
    /**
     * Метод принимает на вход пользователя добавляет ее в Map как ключа,
     * если ли такой ключ в карте нет и если его нет,
     * то произвести вставку данных.
     * @param user пользователь который добавляется в Map.
     */

     public void addUser(User user) {
            users.putIfAbsent(user,
                    new ArrayList<Account>());
    }
    /**
     * Метод принимает на вход номер паспорта и счет добавляет ее в Map,
     * если ли такой ключ в карте есть,
     * то произвести вставку данных.
     * @param passport паспорт пользователя для поиска пользователя в Map.
     * @param account счет пользователя для добовления в список счетов.
     */

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
        }
    }
    /**
     * Метод принимает на вход номер паспорта для поиска ползователя в Map,
     * если ли такой ключ в карте есть,
     * то вернет пользователя, если нет то null.
     * @param passport паспорт пользователя для поиска пользователя в Map.
     * @return возвращает пользователя по passport
     */

    public User findByPassport(String passport) {
        User user = null;
        for (User value : users.keySet()) {
            if (value.getPassport().equals(passport)) {
                user = value;
                break;
            }
        }
        return user;
    }
    /**
     * Метод принимает на вход номер паспорта и реквизит для поиска в Map,
     * сперва находить пользователя и в счетах пользователя введет поиск по реквизиту.
     * @param passport паспорт пользователя для поиска пользователя в Map.
     * @param requisite для поиска счета пользователя.
     * @return возвращает счет найденного по реквизиту
     */

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            for (Account account : accountList) {
                if (account.getRequisite().equals(requisite)) {
                        return account;
                }
            }
        }
        return null;
    }
    /**
     * Метод принимает на вход номер паспорта и реквизит для поиска в Map,
     * сперва находить пользователя для перевода денег и в srcRequisite пользователя
     * проверяеться сумма перевода,
     * если сумма перевода имееться то переводиться на счет destRequisite.
     * @param srcPassport паспорт пользователя для поиска пользователя в Map.
     * @param srcRequisite для поиска счета пользователя.
     * @param destPassport паспорт пользователя для поиска пользователя в Map.
     * @param destRequisite для поиска счета пользователя.
     * @return возвращает true если перевод был успешным
     */

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite,
                                  double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null) {
            if (srcAccount.getBalance() >= amount) {
                destAccount.setBalance(destAccount.getBalance() + amount);
                srcAccount.setBalance(srcAccount.getBalance() - amount);
                rsl = true;
            }
        }
        return rsl;
    }
}
