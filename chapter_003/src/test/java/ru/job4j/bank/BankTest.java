package ru.job4j.bank;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class BankTest {

    @Test
    public void whenAddUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "111111");
        User user2 = new User("Petrov", "222222");
        bank.addUser(user1);
        bank.addUser(user2);
        assertThat(bank.findUserByPassport("111111"), is(user1));
    }

    @Test
    public void whenDeleteUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "111111");
        bank.addUser(user1);
        bank.deleteUser(user1);
        assertThat(bank.findUserByPassport("111111"), is((User) null));
    }

    @Test
    public void whenAddAccountToUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "111111");
        bank.addUser(user1);
        Account account1 = new Account(10000, "10");
        Account account2 = new Account(15000, "15");
        bank.addAccountToUser("111111", account1);
        bank.addAccountToUser("111111", account2);
        assertThat(bank.getUserAccounts("111111").get(0), is(account1));
        assertThat(bank.getUserAccounts("111111").get(1), is(account2));
    }

    @Test
    public void whenDeleteAccountFromUser() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "111111");
        bank.addUser(user1);
        Account account1 = new Account(10000, "10");
        Account account2 = new Account(15000, "15");
        bank.addAccountToUser("111111", account1);
        bank.addAccountToUser("111111", account2);
        assertThat(bank.getUserAccounts("111111").get(0), is(account1));
        bank.deleteAccountFromUser("111111", account1);
        assertThat(bank.getUserAccounts("111111").get(0), is(account2));
    }

    @Test
    public void whenTransferMoney() {
        Bank bank = new Bank();
        User user1 = new User("Ivanov", "111111");
        User user2 = new User("Petrov", "222222");
        bank.addUser(user1);
        bank.addUser(user2);
        Account account1 = new Account(10000, "10");
        Account account2 = new Account(15000, "15");
        bank.addAccountToUser("111111", account1);
        bank.addAccountToUser("222222", account2);
        bank.transferMoney("111111", "10", "222222", "15", 3500);
        assertThat(bank.getUserAccounts("111111").get(0).getValue(), is(6500.0));
        assertThat(bank.getUserAccounts("222222").get(0).getValue(), is(18500.0));
    }

    @Test
    public void whenNotFoundRequisites() {
        Bank bank = new Bank();
        assertThat(bank.findAccountByRequisites("111", "111"), is((Account) null));
    }
}