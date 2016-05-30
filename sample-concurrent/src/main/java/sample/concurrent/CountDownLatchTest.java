package sample.concurrent;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * CountDownLatchTest.java
 * Description:P2-等待多个并发事件完成
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class CountDownLatchTest {

    public static final int PLAYER_AMOUNT = 5;

    public static void main(String[] args) {
        CountDownLatch beginLatch = new CountDownLatch(1);
        CountDownLatch endLatch = new CountDownLatch(PLAYER_AMOUNT);
        ExecutorService executorService = Executors.newFixedThreadPool(PLAYER_AMOUNT);
        for(int i = 1; i <= PLAYER_AMOUNT; i++){
            executorService.execute(new Player(i, beginLatch, endLatch));
        }

        System.out.println("begin");
        beginLatch.countDown();

        try {
            endLatch.await();
        } catch(InterruptedException e){
            e.printStackTrace();
        } finally {
            System.out.println("end");
            executorService.shutdown();
        }

    }

    static class Player extends Thread{
        private int id;
        private CountDownLatch beginLatch;
        private CountDownLatch endLatch;

        public Player(int id, CountDownLatch beginLatch, CountDownLatch endLatch) {
            this.id = id;
            this.beginLatch = beginLatch;
            this.endLatch = endLatch;
        }

        @Override
        public void run() {
            assert null != beginLatch : "beginLatch cannot be empty";
            assert null != endLatch : "endLatch cannot be empty";

            try {
                beginLatch.await();
//                Thread.sleep(2000);
                System.out.println(String.format("Player:%s is arrived.", id));
            } catch(InterruptedException e){
                e.printStackTrace();
            } finally{
                endLatch.countDown();
            }

        }
    }
}