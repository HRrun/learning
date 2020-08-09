package com.study;

import com.study.consumer.BlockConsumer;
import com.study.consumer.ThreadConsumer;
import com.study.producer.BlockProducer;
import com.study.producer.ThreadProducer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;

public class TestMain {
    public static void main(String... args){
        threadQueueTest();
    }

    private static void threadQueueTest() {
        Queue queue = new LinkedList();
        ThreadProducer producer = new ThreadProducer(queue);
        ThreadConsumer consumer = new ThreadConsumer(queue);
        producer.start();
        consumer.start();
    }

    private static void blockQueueTest(){
        BlockingDeque queue = new LinkedBlockingDeque();
        BlockProducer producer = new BlockProducer(queue);
        BlockConsumer consumer = new BlockConsumer(queue);
        Thread p = new Thread(producer);
        Thread c = new Thread(consumer);
        p.start();
        c.start();
    }
}
