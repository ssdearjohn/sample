package sample.leetcode;

/**
 * ReverseString.java
 * Description:reverse the string
 * Created by John.uwenxuan on 2016/5/5.
 */
public class ReverseString {

    /**
     * Write a function that takes a string as input and returns the string reversed.
     * Example:Given s = "hello.", return ".olleh".
     *
     * @param s
     * @return
     */
    public static String reverseString(String s) {
        if (null == s || "".equals(s)) {
            return s;
        }
        char[] target = new char[s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            target[s.length() - 1 - i] = s.charAt(i);
        }
        return String.valueOf(target);
    }
}
