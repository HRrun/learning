package com.study.producer;

import java.util.concurrent.BlockingDeque;

public class BlockProducer implements Runnable {
    private BlockingDeque queue;
    public BlockProducer(BlockingDeque queue) {
        this.queue = queue;
    }
    @Override
    public void run() {
        for (int i=1; i<10; i++) {
            System.out.println("producer offer: " + i);
            try {
                queue.put(i);
            }catch (Exception e) {
                e.printStackTrace();
            }

        }

    }
}
