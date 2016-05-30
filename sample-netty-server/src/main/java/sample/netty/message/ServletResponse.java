package sample.netty.message;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/**
 * ServletResponse.java
 * Description:
 * Created by John.Huwenxuan on 2016/4/19.
 */
public class ServletResponse extends ServletMessage implements Response{

    public ServletResponse() {
    }

    public ServletResponse(Message message) {
        super(message);
    }

    @Override
    public void setParameter(String name, String value) {
        super.setHeader(name, value);
    }

    @Override
    public OutputStream getOutputStream() throws IOException {
        if(getContent() instanceof File){
            return new FileOutputStream((File) getContent());
        }
        throw new IOException("cannot response");
    }
}
