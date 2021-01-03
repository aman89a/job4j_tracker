package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BankService {
    private Map<User, List<Account>> users = new HashMap<>();
    public void addUser(User user) {
        if (!users.containsKey(user)) {
            users.put(user, new ArrayList<Account>());
        }
    }

    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (!accountList.contains(account)) {
                accountList.add(account);
            }
            users.put(user, accountList);
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User value : users.keySet()){
            if (value.getPassport().equals(passport)) {
                user = value;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accountList = users.get(user);
            if (accountList != null) {
                for (Account account : accountList) {
                    if (account.getRequisite() == requisite) {
                        return account;
                    }
                }
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        User userSrc = findByPassport(srcPassport);
        User userDest = findByPassport(destPassport);
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.getBalance() >= amount && srcAccount != null && destAccount != null) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            List<Account> accountListSrc = users.get(userSrc);
            if (accountListSrc.contains(srcAccount)) {
                int index = accountListSrc.indexOf(srcAccount);
                accountListSrc.add(index, srcAccount);
            }
            List<Account> accountListDest = users.get(userDest);
            if (accountListDest.contains(destAccount)) {
                int index = accountListDest.indexOf(destAccount);
                accountListDest.add(index, destAccount);
            }
            users.putIfAbsent(userSrc, accountListSrc);
            users.putIfAbsent(userDest, accountListDest);
            rsl = true;
        }
        return rsl;
    }
}
