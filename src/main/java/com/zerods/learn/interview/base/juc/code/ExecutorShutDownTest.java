package com.zerods.learn.interview.base.juc.code;

import java.io.IOException;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author gengchao05 create on 2020/04/13
 */
public class ExecutorShutDownTest {
    public static final Integer TASK_NUM = 10;

    private static ExecutorService pool = new ThreadPoolExecutor(
            2, 4,
            2, TimeUnit.SECONDS,
            new ArrayBlockingQueue<>(10),
            new ShutDownThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );;

    public static void main(String[] args) throws InterruptedException, IOException {
        for (int i = 0; i < TASK_NUM; i++) {
            pool.execute(new ThreadTask(i));
        }

        TimeUnit.SECONDS.sleep(2);


        System.out.println("Error happened, terminate executing tasks");
        pool.shutdown();
        if (pool.isShutdown()) {
            System.out.println("The ThreadPool is shutdown");
        }

        for (int i = TASK_NUM; i < TASK_NUM * 2; i++) {
            pool.execute(new ThreadTask(i));
        }

        System.out.println("Main ends");
        while (!pool.isTerminated()) {

        }

        System.out.println("exit");
    }
}

class ThreadTask implements Runnable {
    private Integer taskNum;

    public ThreadTask(Integer taskNum) {
        this.taskNum = taskNum;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + " start to execute Task " + taskNum + " =====>");
        try {
            TimeUnit.SECONDS.sleep(5);
            System.out.println("^_^  Task + " + taskNum + " done!");
        } catch (InterruptedException e) {
            System.out.println("┭┮﹏┭┮ Task" + taskNum + " interrupt unexpectedly");
        }
    }
}

class ShutDownThreadFactory implements ThreadFactory {
    private AtomicInteger threadNum = new AtomicInteger();

    @Override
    public Thread newThread(Runnable r) {
        threadNum.incrementAndGet();
        return new Thread(r,"Thread" + threadNum.get());
    }
}
