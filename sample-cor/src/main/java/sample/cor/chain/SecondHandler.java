package sample.cor.chain;

import sample.cor.Handler;

/**
 * SecondHandler.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class SecondHandler extends Handler {
    @Override
    public void handleRequest() {
        System.out.println("second handler");
    }
}
