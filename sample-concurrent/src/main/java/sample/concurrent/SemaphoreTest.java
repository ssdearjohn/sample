package sample.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * SemaphoreTest.java
 * Description:P1-控制并发访问多个资源
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class SemaphoreTest {
    private static final int CLIENT_AMOUNT = 20;
    private static final int THREAD_ALLOW = 5;

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(THREAD_ALLOW);

        for (int i = 0; i < CLIENT_AMOUNT; i++) {
            executorService.execute(new Access(i, semaphore));
        }
        executorService.shutdown();
    }

    static class Access extends Thread {
        private int id;
        private Semaphore semaphore;

        public Access(int id, Semaphore semaphore) {
            this.id = id;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            assert null != semaphore : "semaphore cannot be null";
            try {
                semaphore.acquire();
                Thread.sleep(2000);
                System.out.println(String.format("%s is done", id));
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                semaphore.release();
            }

        }
    }
}
