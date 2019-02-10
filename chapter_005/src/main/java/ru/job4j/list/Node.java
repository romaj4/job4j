package ru.job4j.list;

/**
 * @author Roman Korolchuk (rom.kor@yandex.ru)
 * @version $Id$
 * @since 0.1
 */
public class Node<T> {

    T value;

    Node<T> next;

    public Node(T value) {
        this.value = value;
    }

    boolean hasCycle(Node first) {
        boolean rst = false;
        Node slowStep = first;
        Node fastStep = first;
        while (fastStep != null && fastStep.next != null) {
            slowStep = slowStep.next;
            fastStep = fastStep.next.next;
            if (slowStep == fastStep) {
                rst = true;
                break;
            }
        }
        return rst;
    }
}
