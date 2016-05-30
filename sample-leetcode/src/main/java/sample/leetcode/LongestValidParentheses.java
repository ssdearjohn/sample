package sample.leetcode;

import java.util.Stack;

/**
 * LongestValidParentheses.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/5.
 */
public class LongestValidParentheses {
    /**
     * Given a string containing just the characters '(' and ')',
     * find the length of the longest valid (well-formed) parentheses substring.
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     *
     * @param s
     * @return
     */
    public static int longestValidParentheses(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }
        int maxlen = 0, len = 0;
        final char left = '(';
        final char right = ')';
        boolean[] booleans = new boolean[s.length()];
        Stack<Integer> stack = new Stack();
        //
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (left == c) {
                stack.push(i);
            } else if (right == c) {
                if (!stack.isEmpty()) {
                    booleans[i] = Boolean.TRUE;
                    booleans[stack.peek()] = Boolean.TRUE;
                    stack.pop();
                }
            }
        }

        for (int i = 0; i < s.length(); i++) {
            if (booleans[i]) {
                len++;
            } else {
                len = 0;
            }
            if (maxlen < len) {
                maxlen = len;
            }
        }

        return maxlen;
    }
}
