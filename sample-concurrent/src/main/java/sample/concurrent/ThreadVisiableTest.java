package sample.concurrent;

import java.util.concurrent.TimeUnit;

/**
 * ThreadVisiableTest.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/24.
 */
public class ThreadVisiableTest {
    private static boolean flag = true;

    public static void main(String[] args) throws Exception {
        new Thread() {
            @Override
            public void run() {
                int i = 0;
                while (flag) {
                    //once remove this I/O operation, this thread will deep in dead cycle
                    System.out.println(i++);
                }
            }
        }.start();

        TimeUnit.SECONDS.sleep(1);

        new Thread() {
            @Override
            public void run() {
                flag = false;
            }
        }.start();

    }
}
