package sample.netty.handler;

import org.apache.log4j.Logger;
import org.jboss.netty.channel.*;
import sample.netty.container.NettyServletContainer;
import sample.netty.message.ServletMessage;
import sample.netty.message.ServletResponse;

import java.io.File;

/**
 * NettyServerHandler.java
 * Description:My Server Handler
 * Created by John.Huwenxuan on 2016/4/15.
 */
public class NettyServerHandler extends SimpleChannelUpstreamHandler {

    private static final Logger logger = Logger.getLogger(NettyServerHandler.class);
    private NettyServletContainer servletContainer;

    public void setServletContainer(NettyServletContainer servletContainer) {
        this.servletContainer = servletContainer;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, ExceptionEvent e) throws Exception {
        Throwable cause = e.getCause();
        cause.printStackTrace();
        ctx.getChannel().close();
    }

    @Override
    public void messageReceived(ChannelHandlerContext ctx, MessageEvent e) throws Exception {
        final Channel channel = e.getChannel();
        Object msg = e.getMessage();
        if(!(msg instanceof ServletMessage)){
            if(logger.isInfoEnabled()){
                logger.info(String.format("[%s] Message [%s] could not be identified!", channel.getId(), msg.getClass().getName()));
            }
            return;
        }

        final ServletMessage servletRequest = (ServletMessage) msg;
        final ServletMessage servletResponse = initResponseMessage(channel);
        if(logger.isDebugEnabled()){
            logger.debug(String.format("[%s] start to process the Message...", channel.getId()));
        }

        //TODO dosomething

        ChannelFuture future = channel.write(servletResponse, channel.getRemoteAddress());
        //
        String keepAlive = servletRequest.getHeader("Keep-Alive", "true");
        if("false".equalsIgnoreCase(keepAlive)){
            future.addListener(ChannelFutureListener.CLOSE);
        }

        if(logger.isDebugEnabled()){
            logger.debug(String.format("[%s] end of the Message processing!", channel.getId()));
        }

    }

    private ServletMessage initResponseMessage(Channel channel){
        ServletResponse servletResponse = new ServletResponse();
        File response = new File(System.getProperty("server.temp.location"), String.format("resp_%s", String.valueOf(channel.getId())));
        servletResponse.setContent(response);
        return servletResponse;
    }

}
