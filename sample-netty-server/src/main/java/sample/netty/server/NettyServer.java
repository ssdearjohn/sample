package sample.netty.server;

import org.apache.log4j.Logger;
import org.jboss.netty.bootstrap.ServerBootstrap;
import org.jboss.netty.channel.ChannelFactory;
import org.jboss.netty.channel.ChannelPipelineFactory;
import org.springframework.util.Assert;

import java.net.InetSocketAddress;
import java.net.SocketAddress;

/**
 * NettyServer.java
 * Description:
 * Created by John.Huwenxuan on 2016/4/19.
 */
public class NettyServer implements Server {
    private static final Logger logger = Logger.getLogger(NettyServer.class);

    private int port;
    private String protocol;
    private ChannelFactory channelFactory;
    private ChannelPipelineFactory channelPipelineFactory;
    private ServerBootstrap serverBootstrap;

    public NettyServer() {
    }

    public void setPort(int port) {
        this.port = port;
    }

    public void setProtocol(String protocol) {
        this.protocol = protocol;
    }

    public void setChannelFactory(ChannelFactory channelFactory) {
        this.channelFactory = channelFactory;
    }

    public void setChannelPipelineFactory(ChannelPipelineFactory channelPipelineFactory) {
        this.channelPipelineFactory = channelPipelineFactory;
    }

    public void setServerBootstrap(ServerBootstrap serverBootstrap) {
        this.serverBootstrap = serverBootstrap;
    }

    public ChannelFactory getChannelFactory() {
        Assert.notNull(channelFactory);
        return channelFactory;
    }

    public ChannelPipelineFactory getChannelPipelineFactory() {
        Assert.notNull(channelPipelineFactory);
        return channelPipelineFactory;
    }

    @Override
    public void startup() {
        Assert.notNull(port, "port could not be null");
        SocketAddress socketAddress = new InetSocketAddress(port);
        serverBootstrap = new ServerBootstrap(getChannelFactory());
        serverBootstrap.setPipelineFactory(getChannelPipelineFactory());
        serverBootstrap.bind(socketAddress);
        if(logger.isInfoEnabled()){
            logger.info(String.format("Protocol[%s] had already start with Port [%s]", protocol, String.valueOf(port)));
        }
    }

    @Override
    public void shutdown() {
        serverBootstrap.shutdown();
    }
}
