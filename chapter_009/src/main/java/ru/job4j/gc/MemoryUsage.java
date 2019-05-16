package ru.job4j.gc;

public class MemoryUsage {

    public static class User {

        public String name;

        public int age;

        public User() {
        }

        public User(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        protected void finalize() throws Throwable {
            super.finalize();
            System.out.println("finalize");
        }
    }

    public static void main(String[] args) {
        System.out.println("start");
        User[] user = new User[100000];
        for (int i = 0; i < user.length; i++) {
            user[i] = new User("test" + i, i);
        }
        for (int i = 0; i < 25000; i++) {
            user[i] = null;
        }
        User[] userEmpty = new User[10000];
        for (int i = 0; i < userEmpty.length; i++) {
            userEmpty[i] = new User();
        }
        System.out.println("finish");
        info();
    }

    public static void info() {
        int mb = 1024 * 1024;
        Runtime runtime = Runtime.getRuntime();
        System.out.println("Heap utilization statistics:");
        System.out.println("Fre memory: " + runtime.freeMemory() / mb);
        System.out.println("Total memory: " + runtime.totalMemory() / mb);
        System.out.println("Used memory: " + (runtime.totalMemory() - runtime.freeMemory()) / mb);
        System.out.println("Max memory: " + runtime.maxMemory() / mb);
    }
}
