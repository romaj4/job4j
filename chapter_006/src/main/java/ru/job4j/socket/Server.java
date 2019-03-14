package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Server {

    private final Socket socket;

    public Server(Socket socket) {
        this.socket = socket;
    }

    public void start() throws IOException {
        PrintWriter out = new PrintWriter(this.socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(this.socket.getInputStream()));
        Map<String, String> answersMap = this.generateAnswers();
        String ask;
        do {
            System.out.println("wait command ...");
            ask = in.readLine();
            System.out.println(ask);
            if (answersMap.containsKey(ask)) {
                out.println(answersMap.get(ask));
                out.println();
            } else {
                out.println("I don't understand");
                out.println();
            }
        } while (!("exit".equals(ask)));
    }

    public Map<String, String> generateAnswers() {
        Map<String, String> map = new HashMap<>();
        map.put("hello", "Hello, dear friend, I'm an oracle.");
        map.put("how are you", "I'm fine, and you?");
        map.put("how weather", "It is rainy. But it will soon improve");
        map.put("exit", "Goodbye. It was nice to talk");
        return map;
    }

    public static void main(String[] args) {
        try (Socket socket = new ServerSocket(4004).accept()) {
            new Server(socket).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
