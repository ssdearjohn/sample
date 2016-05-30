package sample.netty.codec;


import org.apache.log4j.Logger;
import org.jboss.netty.channel.Channel;
import org.jboss.netty.channel.ChannelHandlerContext;
import org.jboss.netty.channel.ChannelLocal;
import org.jboss.netty.handler.codec.oneone.OneToOneDecoder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.ResourceLoader;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternUtils;
import org.springframework.core.type.classreading.MetadataReaderFactory;
import org.springframework.core.type.classreading.SimpleMetadataReaderFactory;

import java.io.File;

/**
 * StrServletRequestDecoder.java
 * Description:str message decoder
 * Created by John.Huwenxuan on 2016/4/18.
 */
public class StrServletRequestDecoder extends OneToOneDecoder implements ResourceLoaderAware, InitializingBean {
    protected MetadataReaderFactory metadataReaderFactory;
    protected ResourcePatternResolver resourcePatternResolver;
    private static final Logger logger = Logger.getLogger(StrServletRequestDecoder.class);
    private String charset = "GBK";//default charset
    private String tempDir = System.getProperty("java.io.tmp");//default temp directory
    private ChannelLocal<File> fileChannelLocal = new ChannelLocal<File>(true){
        @Override
        protected File initialValue(Channel channel) {
            return new File(tempDir, String.format("req_%s", channel.getId()));
        }
    };

    public void setCharset(String charset) {
        this.charset = charset;
    }

    public void setTempDir(String tempDir) {
        this.tempDir = tempDir;
    }

    @Override
    protected Object decode(ChannelHandlerContext channelHandlerContext, Channel channel, Object o) throws Exception {
        return "";
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.metadataReaderFactory = new SimpleMetadataReaderFactory(resourceLoader);
        this.resourcePatternResolver = ResourcePatternUtils.getResourcePatternResolver(resourceLoader);
    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
