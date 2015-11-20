package mina.server;

import java.util.Date;

import org.apache.mina.core.service.IoHandler;
import org.apache.mina.core.session.IdleStatus;
import org.apache.mina.core.session.IoSession;

/**
 * Created by Loftor on 2014/8/15.
 */
public class TimeServerHandler implements IoHandler {

    @Override
    public void exceptionCaught(IoSession arg0, Throwable arg1)
            throws Exception {
    	  System.out.println("exceptionCaught");
        arg1.printStackTrace();

    }

    @Override
    public void messageReceived(IoSession session, Object message) throws Exception {

        String str = message.toString();

        System.out.println("messageReceived 接受到的消息:" + str);

        if (str.trim().equalsIgnoreCase("quit")) {
            session.close(true);
            return;
        }
        Date date = new Date();
        session.write(date.toString());
        System.out.println("Message written...");
    }

    @Override
    public void messageSent(IoSession arg0, Object arg1) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("messageSent 发送信息:" + arg1.toString());
    }

    @Override
    public void sessionClosed(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("sessionClosed IP:" + session.getRemoteAddress().toString() + "断开连接");
    }

    @Override
    public void sessionCreated(IoSession session) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("generated IP:" + session.getRemoteAddress().toString());
    }

    @Override
    public void sessionIdle(IoSession session, IdleStatus status) throws Exception {
        // TODO Auto-generated method stub
        System.out.println("IDLE " + session.getIdleCount(status));

    }

    @Override
    public void sessionOpened(IoSession arg0) throws Exception {
        // TODO Auto-generated method stub
    	 System.out.println("sessionOpened " );
    }
}