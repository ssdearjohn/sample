package sample.leetcode;

import org.junit.Test;

/**
 * IntegerBreakTest.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/5.
 */
public class IntegerBreakTest {
    @Test
    public void testIntegerBreak() {
        assert 36 == IntegerBreak.integerBreak(10) : String.format("'%s' expect %s but %s", 10, 36, IntegerBreak.integerBreak(10));
        assert 1 == IntegerBreak.integerBreak(2) : String.format("'%s' expect %s but %s", 2, 1, IntegerBreak.integerBreak(10));
    }
}
