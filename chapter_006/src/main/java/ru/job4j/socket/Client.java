package ru.job4j.socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Client {

    private final String ip;

    private final int port;

    public Client(String ip, int port) {
        this.ip = ip;
        this.port = port;
    }

    public void start() throws IOException {
        Socket socket = new Socket(InetAddress.getByName(ip), port);
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        Scanner console = new Scanner(System.in);
        String consoleInput;
        do {
            consoleInput = console.nextLine();
            out.println(consoleInput);
            String str = in.readLine();
            while (!(str.isEmpty())) {
                System.out.println(str);
            }
        } while (!(consoleInput.equals("exit")));
    }

    public static void main(String[] args) {
        try {
            new Client("127.0.0.1", 4004).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
