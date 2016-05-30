package sample.netty.message;

import java.util.List;
import java.util.Map;

/**
 * Message.java
 * Description:message carrier interface
 * Created by John.Huwenxuan on 2016/4/18.
 */
public interface Message {
    String HEADER_PROTOCOL = "Message-Protocol";

    String getHeader(String name, String defaultHeader);

    List<String> getHeader(String name);

    Map<String, List<String>> getHeaders();

    void addHeader(String name, Object value);

    void setHeader(String name, Object value);

    void clearHeaders();

    void setHeaders(Map<String, List<String>> headers);

    Object getContent();

    void setContent(Object content);
}
