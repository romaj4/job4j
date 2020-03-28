package ru.job4j.blockingqueue;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SimpleBlockingQueueTest {

    @Test
    public void whenOneConsumerAndOneProducer() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(4);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 11; i++) {
                queue.offer(i);
            }
        });
        Thread consumer = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        int expectSize = 2;
        producer.start();
        consumer.start();
        producer.join();
        consumer.join();
        assertThat(expectSize, is(queue.getSize()));
    }

    @Test
    public void whenTwoConsumerAndOneProducer() throws InterruptedException {
        SimpleBlockingQueue<Integer> queue = new SimpleBlockingQueue<>(4);
        Thread producer = new Thread(() -> {
            for (int i = 0; i < 18; i++) {
                queue.offer(i);
            }
        });
        Thread consumer1 = new Thread(() -> {
            for (int i = 0; i < 9; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread consumer2 = new Thread(() -> {
            for (int i = 0; i < 6; i++) {
                try {
                    queue.poll();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        int expectSize = 3;
        producer.start();
        consumer1.start();
        consumer2.start();
        producer.join();
        consumer1.join();
        consumer2.join();
        assertThat(expectSize, is(queue.getSize()));
    }
}