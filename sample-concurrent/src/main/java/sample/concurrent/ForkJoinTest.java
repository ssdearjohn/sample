package sample.concurrent;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

/**
 * ForkJoinTest.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class ForkJoinTest {
    public static final ForkJoinPool forkJoinPool = new ForkJoinPool();

    public static void main(String[] args) {
        int n = 26;
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = i;
        }
        forkJoinPool.invoke(new SubTask(a, 0, n));
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }
    }
}

/**
 * 将大数组不断分解为更短小的子数组，当子数组长度不超过10的时候，对其中所有元素进行加1操作
 */
class SubTask extends RecursiveAction {
    private int[] a;
    private int beg;
    private int end;

    public SubTask(int[] a, int beg, int end) {
        this.a = a;
        this.beg = beg;
        this.end = end;
    }

    @Override
    protected void compute() {
        if (end - beg > 10) {
            int mid = (beg + end) / 2;
            SubTask t1 = new SubTask(a, beg, mid);
            SubTask t2 = new SubTask(a, mid, end);
            invokeAll(t1, t2);
        } else {
            for (int i = beg; i < end; i++) {
                a[i] = a[i] + i;
            }
        }
    }
}