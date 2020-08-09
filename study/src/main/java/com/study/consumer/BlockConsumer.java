package com.study.consumer;

import java.util.concurrent.BlockingDeque;

public class BlockConsumer implements Runnable {
    private BlockingDeque queue;
    public BlockConsumer(BlockingDeque queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Object o = queue.take();
                System.out.println("concumer poll: " + o);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
}
