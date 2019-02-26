package ru.job4j.control;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public class Analize {

    /**
     * Определяет разницу между начальным и конечным состоянием списков.
     *
     * @param previous начальный список.
     * @param current  конечный список.
     * @return статистика.
     */
    public Info diff(List<User> previous, List<User> current) {
        int addCount = 0;
        int changeCount = 0;
        int deleteCount = 0;
        Map<Integer, User> mapUser = new HashMap<>();
        previous.forEach(user -> mapUser.put(user.getId(), user));
        for (User currentUser : current) {
            Optional<User> checkUser = Optional.ofNullable(mapUser.remove(currentUser.getId()));
            if (checkUser.isEmpty()) {
                addCount++;
            } else if (!currentUser.getName().equals(checkUser.get().getName())) {
                changeCount++;
            }
        }
        deleteCount = mapUser.size();
        return new Info(addCount, changeCount, deleteCount);
    }

    public static class Info {

        private int added;

        private int changed;

        private int deleted;

        public Info(int added, int changed, int deleted) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }

        public int getAdded() {
            return added;
        }

        public int getChanged() {
            return changed;
        }

        public int getDeleted() {
            return deleted;
        }
    }
}
