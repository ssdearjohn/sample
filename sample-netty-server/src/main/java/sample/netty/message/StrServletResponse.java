package sample.netty.message;

import java.util.*;
/**
 * StrServletResponse.java
 * Description:Str-Protocol response Mmssage carrier
 * Created by John.Huwenxuan on 2016/4/18.
 */
public class StrServletResponse extends ServletMessage {

    public StrServletResponse() {
    }

    public StrServletResponse(Message message) {
        super(message);
    }

    public Map<String, Object> getData(){
        Map<String, Object> map = new HashMap<String, Object>();
        for (String name : getHeaders().keySet()) {
            String value = getHeader(name, null);
            map.put(name, value);
        }
        map.put("page", getContent());
        return map;
    }
}
