package com.study.consumer;

import java.util.Queue;

public class ThreadConsumer extends Thread {
    private Queue queue;

    public ThreadConsumer(Queue queue){
        this.queue = queue;
    }
    public void run(){
        while (true){
            synchronized (queue){
                if (queue.isEmpty()) {
                    try {
                        wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    Object o = queue.poll();
                    System.out.println("consumer poll : " + o);
                    notifyAll();
                }
            }
        }
    }
}
