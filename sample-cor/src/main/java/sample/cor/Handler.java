package sample.cor;

/**
 * Handler.java
 * Description:责任链处理器
 * Created by John.Huwenxuan on 2016/5/13.
 */
public abstract class Handler {
    protected Handler successor;

    protected abstract void handleRequest();

    public Handler getSuccessor() {
        return successor;
    }

    public void setSuccessor(Handler successor) {
        this.successor = successor;
    }

}
