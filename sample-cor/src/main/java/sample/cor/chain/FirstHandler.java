package sample.cor.chain;

import sample.cor.Handler;

/**
 * FirstHandler.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class FirstHandler extends Handler {

    @Override
    public void handleRequest() {
        System.out.println("first handle");
    }

}
