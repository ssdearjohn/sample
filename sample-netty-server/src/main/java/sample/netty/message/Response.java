package sample.netty.message;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Response.java
 * Description:
 * Created by John.Huwenxuan on 2016/4/19.
 */
public interface Response extends Message {

    void setParameter(String name, String value);

    OutputStream getOutputStream() throws IOException;
}
