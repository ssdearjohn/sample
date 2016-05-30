package sample.netty.codec;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.handler.codec.oneone.OneToOneEncoder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;

/**
 * StrServletResponseEncoder.java
 * Description:str message encoder
 * Created by John.Huwenxuan on 2016/4/18.
 */
public class StrServletResponseEncoder extends OneToOneEncoder implements ResourceLoaderAware, InitializingBean {

    private static final Logger logger = Logger.getLogger(StrServletResponseEncoder.class);
    private String charset = "GBK";//default charset

    public void setCharset(String charset) {
        this.charset = charset;
    }

    @Override
    protected Object encode(ChannelHandlerContext channelHandlerContext, Channel channel, Object o) throws Exception {
        return null;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
