package sample.leetcode;

import org.junit.Test;

/**
 * testLongestValidParentheses.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/5.
 */
public class LongestValidParenthesesTest {

    @Test
    public void test() {
        assert 4 == LongestValidParentheses.longestValidParentheses("()()") : String.format("'%s' expect '%s' but %s", "()()", 4, LongestValidParentheses.longestValidParentheses("()()"));
        assert 0 == LongestValidParentheses.longestValidParentheses("))((") : String.format("'%s' expect '%s' but %s", "))((", 0, LongestValidParentheses.longestValidParentheses("))(("));
        assert 4 == LongestValidParentheses.longestValidParentheses(")()())") : String.format("'%s' expect '%s' but %s", ")()())", 4, LongestValidParentheses.longestValidParentheses(")()())"));
        assert 2 == LongestValidParentheses.longestValidParentheses("(()") : String.format("'%s' expect '%s' but %s", "(()", 2, LongestValidParentheses.longestValidParentheses("(()"));
        assert 6 == LongestValidParentheses.longestValidParentheses("()(())") : String.format("'%s' expect '%s' but %s", "()(())", 6, LongestValidParentheses.longestValidParentheses("()(())"));
        assert 2 == LongestValidParentheses.longestValidParentheses("()(()") : String.format("'%s' expect '%s' but %s", "()(()", 2, LongestValidParentheses.longestValidParentheses("()(()"));
    }
}
