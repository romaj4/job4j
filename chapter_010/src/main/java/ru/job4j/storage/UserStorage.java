package ru.job4j.storage;

import net.jcip.annotations.GuardedBy;
import net.jcip.annotations.ThreadSafe;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
@ThreadSafe
public class UserStorage {
    @GuardedBy("this")
    private Map<Integer, User> storage = new HashMap<>();

    public synchronized boolean add(User user) {
        return this.storage.put(user.getId(), user) == null;
    }

    public synchronized boolean delete(User user) {
        return this.storage.remove(user.getId()) != null;
    }

    public synchronized boolean update(User user) {
        return this.storage.put(user.getId(), user) != null;
    }

    public synchronized boolean transfer(int fromId, int toId, int amount) {
        boolean rst = false;
        if (this.storage.containsKey(fromId) && this.storage.containsKey(toId)) {
            User fromUser = this.storage.get(fromId);
            User toUser = this.storage.get(toId);
            int amountFrom = fromUser.getAmount();
            if (amountFrom > amount) {
                fromUser.setAmount(amountFrom - amount);
                toUser.setAmount(toUser.getAmount() + amount);
                rst = true;
            }
        }
        return rst;
    }

    public synchronized Map<Integer, User> getStorage() {
        return this.storage;
    }
}
