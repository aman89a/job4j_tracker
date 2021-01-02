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
        ArrayList<Account> list = (ArrayList<Account>) users.get(user.getPassport());
        for (Account account1 : list) {
            if (account1 == account) {
                list.add(account);
            }
        }
    }

    public User findByPassport(String passport) {
        User user = null;
        for (User value : users.keySet()){
            if (value.getPassport() == passport) {
                user = value;
            }
        }
        return user;
    }

    public Account findByRequisite(String passport, String requisite) {
        List<Account> list = users.get(passport);
        for (Account account : list) {
            if (account.getRequisite() == requisite) {
                return account;
            }
        }
        return null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {

        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount.getBalance() >= amount) {
            destAccount.setBalance(amount);
            rsl = true;
        }
        return rsl;
    }
}
