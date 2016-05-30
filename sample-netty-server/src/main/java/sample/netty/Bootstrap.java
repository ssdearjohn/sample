package sample.netty;


import org.apache.log4j.Logger;
import org.jboss.netty.channel.*;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import sample.netty.server.NettyServer;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * Bootstrap.java
 * Description:Netty Server Bootstrap
 * Created by John.Huwenxuan on 2016/4/15.
 */
public class Bootstrap {
    private static final Logger logger = Logger.getLogger(Bootstrap.class);

    /**
     * resolve the temp directory
     *
     * @param properties
     */
    private static void resolveTempLocation(Properties properties) {
        String tempLocaction = properties.getProperty("server.temp.location");

        if (!StringUtils.hasText(tempLocaction)) {
            properties.put("server.temp.location", System.getProperty("java.io.tmpdir"));
            tempLocaction = System.getProperty("java.io.tmpdir");
        }
        File tempDir = new File(tempLocaction);
        tempDir.mkdirs();
    }

    /**
     * supported protocol for system had be configured in prop file.
     * it delimits by comma.
     *
     * @param properties
     * @return
     */
    private static String[] getSupportedProtocols(Properties properties) {
        String serverProtocolStr = properties.getProperty("server.protocol");
        Assert.hasText(serverProtocolStr, "param [server.protocol] did not be configured");
        String[] serverProtocols = StringUtils.commaDelimitedListToStringArray(serverProtocolStr);
        return serverProtocols;
    }

    /**
     * set the active profile in spring context
     */
    private static void activeProfiles() {
        String[] profiles = new String[]{"default", "strProtocol"};
        System.setProperty("spring.profiles.active", StringUtils.arrayToCommaDelimitedString(profiles));

    }

    public static void main(String[] args) throws InterruptedException {
        activeProfiles();
        //
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-netty-server.xml");
        Properties properties = context.getBean("server", Properties.class);
        //
        resolveTempLocation(properties);
        String[] serverProtocols = getSupportedProtocols(properties);
        //
        for (final String serverProtocol : serverProtocols) {
            String portPropertyName = String.format("server.%s.port", serverProtocol);
            String port = properties.getProperty(portPropertyName);
            Assert.hasText(port, String.format("a port for protocol [%s] configure not yet", portPropertyName));
            //
            ChannelFactory channelFactory = context.getBean(ChannelFactory.class);
            NettyServer server = new NettyServer();
            server.setProtocol(serverProtocol);
            server.setPort(Integer.parseInt(port));
            server.setChannelFactory(channelFactory);
            server.setChannelPipelineFactory(new ChannelPipelineFactory() {
                @Override
                public ChannelPipeline getPipeline() throws Exception {
                    List<ChannelHandler> channelHandlers = new ArrayList((List<ChannelHandler>) context.getBean(String.format("%sCodecHandlers", serverProtocol)));
                    ChannelHandler servletHandler = (ChannelHandler) context.getBean("servletHandler");
                    channelHandlers.add(servletHandler);
                    return Channels.pipeline(channelHandlers.toArray(new ChannelHandler[channelHandlers.size()]));
                }
            });
            server.startup();
        }
    }
}
