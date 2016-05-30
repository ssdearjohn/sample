package sample.netty.message;

import java.util.*;

/**
 * ServletMessage.java
 * Description:servlet message carrier
 * Created by John.Huwenxuan on 2016/4/18.
 */
public abstract class ServletMessage implements Message{

    private Map<String, List<String>> headers = new HashMap<>();
    //
    private Object content = null;

    public ServletMessage() {
    }

    public ServletMessage(Message message) {
        this.headers = message.getHeaders();
        this.content = message.getContent();
    }

    @Override
    public String getHeader(String name, String defaultHeader) {
        List<String> header = headers.get(name);
        if(header==null || headers.isEmpty()) {
            return defaultHeader;
        }
        return header.get(0);
    }

    @Override
    public List<String> getHeader(String name) {
        return headers.get(name);
    }

    @Override
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    @Override
    public void addHeader(String name, Object value) {
        List values = headers.get(name);
        if(values==null) {
            values = new ArrayList<>();
        }
        values.add(value);
        headers.put(name, values);
    }

    @Override
    public void setHeader(String name, Object value) {
        headers.put(name, Arrays.asList(String.valueOf(value)));
    }

    @Override
    public void clearHeaders() {
        headers.clear();
    }

    @Override
    public void setHeaders(Map<String, List<String>> headers) {
        if(headers == null){
            return;
        }

        clearHeaders();
        this.headers.putAll(headers);
    }

    @Override
    public Object getContent() {
        return content;
    }

    @Override
    public void setContent(Object content) {
        this.content = content;
    }
}
