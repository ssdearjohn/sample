package sample.cor;

import sample.cor.chain.FirstHandler;
import sample.cor.chain.SecondHandler;
import sample.cor.chain.ThirdHandler;

/**
 * HandlereChain.java
 * Description:
 * Created by John.Huwenxuan on 2016/5/13.
 */
public class HandlereChain {
    static Handler[] handlers = new Handler[]{new FirstHandler(), new SecondHandler(), new ThirdHandler()};
    public static void main(String[] args) {
        for(Handler handler : handlers){
            handler.handleRequest();
        }
    }
}
