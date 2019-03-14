package ru.job4j.socket;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.Socket;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class ServerTest {

    private static final String LN = System.lineSeparator();

    public void testServer(String input, String expect) throws IOException {
        Socket socket = mock(Socket.class);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        when(socket.getInputStream()).thenReturn(in);
        when(socket.getOutputStream()).thenReturn(out);
        Server server = new Server(socket);
        server.start();
        assertThat(out.toString(), is(expect));
    }

    @Test
    public void whenAskExitThenAnswer() throws IOException {
        this.testServer("exit", String.format("Goodbye. It was nice to talk%s%s", LN, LN));
    }

    @Test
    public void whenAskHelloThenAnswer() throws IOException {
        this.testServer(String.format("hello%sexit", LN),
                String.format("Hello, dear friend, I'm an oracle.%s%sGoodbye. It was nice to talk%s%s", LN, LN, LN, LN));
    }

    @Test
    public void whenUnsupportedAskThenAnswer() throws IOException {
        this.testServer(String.format("helo%sexit", LN),
                String.format("I don't understand%s%sGoodbye. It was nice to talk%s%s", LN, LN, LN, LN));
    }

    @Test
    public void whenAskHowYouThenAnswer() throws IOException {
        this.testServer(String.format("how are you%sexit", LN),
                String.format("I'm fine, and you?%s%sGoodbye. It was nice to talk%s%s", LN, LN, LN, LN));
    }
}