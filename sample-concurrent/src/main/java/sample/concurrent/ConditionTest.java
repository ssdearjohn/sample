package sample.concurrent;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ConditionTest.java
 * Description:A Sample for ReentrantLock and Condition
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class ConditionTest {

    public static void main(String[] args) {
        final ReentrantLock reentrantLock = new ReentrantLock();
        final Condition condition = reentrantLock.newCondition();

        Thread aThread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    //1、this thread will be added in AQS queue when ThreadA calls method lock() by ReentrantLock instance.
                    reentrantLock.lock();
                    System.out.println("Waiting a signal:" + this);
                    //2、this thread will be removed from AQS queue when ThreadA calls method await() by Condition instance,this thread's lock will be released.
                    //3、meantime, this thread will be added in a queue which belongs to Condition instance,this thread needs a Signal to wake it up.
                    condition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //7、线程1被唤醒，继续执行
                System.out.println("catch a new signal:" + this);
                //8、release the lock and finish the work
                reentrantLock.unlock();
            }
        });

        aThread.start();

        Thread bThread = new Thread(new Runnable() {
            @Override
            public void run() {
                //
                //4、因为线程1的锁释放，被唤醒，并判断可以竞争锁，通过reentrantLock.lock()线程2获得锁，加入到AQS等到队列中
                reentrantLock.lock();
                System.out.println("取得锁" + this);
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                //5、线程2调用condition.signal()方法，这时condition的等待队列只有线程1一个节点，于是它被取出来加入到AQS等待队列当中（并未唤醒）
                condition.signal();
                System.out.println("发出信号" + this);
                //6、线程2调用reentrantLock.unlock()方法，线程2从AQS中移除。这时AQS只有线程1，线程2释放锁后，AQS按从头到尾顺序唤醒线程。
                reentrantLock.unlock();
            }
        });

        bThread.start();
    }
}
