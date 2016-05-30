package sample.netty.message;

import java.util.*;
/**
 * StrServletRequest.java
 * Description:Str-Protocol request Mmssage carrier
 * Created by John.Huwenxuan on 2016/4/18.
 */
public class StrServletRequest extends ServletMessage {

    public StrServletRequest() {
    }

    public StrServletRequest(Message message) {
        super(message);
    }

    public StrServletRequest(Map<String, Object> data){
        super.setHeader(HEADER_PROTOCOL, "str");
        for(String key : data.keySet()){
            super.setHeader(key, data.get(key));
        }
    }
}
