package com.study.producer;

import java.util.Queue;

public class ThreadProducer extends Thread {
    private Queue queue;
    private Integer i = 1;
    public ThreadProducer(Queue queue){
        this.queue = queue;
    }

    public void run(){
        while(true) {
            synchronized (queue){
                if (queue.isEmpty() || queue.size() < 10) {
                    System.out.println("producer offer : " + i);
                    queue.offer(i);
                    notifyAll();
                } else {
                    try {
                        wait();
                    } catch (Exception e){
                        e.printStackTrace();
                    }

                }
            }
        }
    }
}
