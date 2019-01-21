package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Bank {

    private Map<User, List<Account>> userMap = new HashMap<>();

    public void addUser(User user) {
        this.userMap.putIfAbsent(user, new ArrayList<>());
    }

    public void deleteUser(User user) {
        this.userMap.remove(user);
    }

    public void addAccountToUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            this.userMap.get(user).add(account);
        }
    }

    public void deleteAccountFromUser(String passport, Account account) {
        User user = findUserByPassport(passport);
        if (user != null) {
            this.userMap.get(user).remove(account);
        }
    }

    public List<Account> getUserAccounts(String passport) {
        return this.userMap.get(findUserByPassport(passport));
    }

    public User findUserByPassport(String passport) {
        return this.userMap.keySet().stream().filter(user -> user.getPassport().equals(passport)).findAny().orElse(null);
    }

    public Account findAccountByRequisites(String passport, String requisite) {
        List<Account> accountList = this.getUserAccounts(passport);
        return accountList != null ? accountList.stream().filter(account -> account.getRequisites().equals(requisite)).findAny().orElse(null) : null;
    }

    public boolean transferMoney(String srcPassport, String srcRequisite, String destPassport, String destRequisite, double amount) {
        boolean rst = false;
        Account srcAccount = findAccountByRequisites(srcPassport, srcRequisite);
        Account destAccount = findAccountByRequisites(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null && srcAccount.getValue() > amount) {
            destAccount.setValue(destAccount.getValue() + amount);
            srcAccount.setValue(srcAccount.getValue() - amount);
            rst = true;
        }
        return rst;
    }
}
