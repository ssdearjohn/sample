package sample.concurrent;

import java.util.concurrent.CyclicBarrier;

/**
 * CyclicBarrierTest.java
 * Description:P3-在同一个点同步任务
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2);
    }
}


