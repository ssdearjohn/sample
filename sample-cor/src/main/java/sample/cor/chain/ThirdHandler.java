package sample.cor.chain;

import sample.cor.Handler;

/**
 * ThirdHandler.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class ThirdHandler extends Handler{
    @Override
    public void handleRequest() {
        System.out.println("third Handler");
    }
}