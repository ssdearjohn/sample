package sample.leetcode;

import org.junit.Test;

/**
 * ReverseStringTest.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/5.
 */
public class ReverseStringTest {

    @Test
    public void reverse() {
        assert ".olleh".equals(ReverseString.reverseString("hello.")) : "string 'hello.' test error";
        assert null == ReverseString.reverseString(null) : "NULL test error";
        assert "".equals(ReverseString.reverseString("")) : "string '' test error";
    }
}
