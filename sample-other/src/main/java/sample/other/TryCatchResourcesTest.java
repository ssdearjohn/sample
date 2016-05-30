package sample.other;

import java.io.*;
import java.nio.charset.Charset;

/**
 * TryCatchResourcesTest.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/26.
 */
public class TryCatchResourcesTest {

    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println(readFirst("e:/测试.txt"));
        File file = new File("e:/测试.txt");
        System.out.println(file.renameTo(file));
    }

    private static String readFirst(String path) throws IOException {
        try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path)), Charset.forName("GBK")))) {
            return bufferedReader.readLine();
        }
    }
}