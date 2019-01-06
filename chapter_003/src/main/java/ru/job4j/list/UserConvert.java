package ru.job4j.list;

import java.util.HashMap;
import java.util.List;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> mapList = new HashMap<>();
        for (User user : list) {
            mapList.put(user.getId(), user);
        }
        return mapList;
    }
}
