package ru.job4j.list;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class UserConvert {

    public HashMap<Integer, User> process(List<User> list) {
        return new HashMap<>(list.stream().collect(Collectors.toMap(User::getId, user -> user)));
    }
}
