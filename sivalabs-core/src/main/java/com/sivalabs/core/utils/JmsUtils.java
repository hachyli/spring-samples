/**
 * 
 */
package com.sivalabs.core.utils;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Queue;
import javax.jms.QueueConnection;
import javax.jms.QueueConnectionFactory;
import javax.jms.QueueSender;
import javax.jms.QueueSession;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;


/**
 * @author skatam
 *
 */
public class JmsUtils
{
	public static void main(String[] args)throws Exception
	{
		send();
		System.out.println("Message Sent...");
		//Thread.sleep(10000);
		recieve();
	}
	
	public static void recieve() throws Exception
	{
		Context context = JndiUtils.getDefaultJBossJndiContext();
		QueueConnectionFactory qcf = JndiUtils.lookup(context, "ConnectionFactory", QueueConnectionFactory.class);
		QueueConnection connection = (QueueConnection) qcf.createConnection();
		connection.start();
		QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue= JndiUtils.lookup(context, "queue/ExpiryQueue",Queue.class);
		MessageConsumer queueConsumer = queueSession.createConsumer(queue);
		/*queueConsumer.setMessageListener(new TestMessageListener());
		System.out.print("waiting for messages");
        for (int i = 0; i < 10; i++) 
        {
          Thread.sleep(1000);
          System.out.print(".");
        }*/
		
		while(true)
		{
			TextMessage msg = (TextMessage) queueConsumer.receive();
			System.out.println("Message------>"+msg.getText());
		}
		//connection.close();
	}
	
	public static void send() throws Exception
	{
		Context context = JndiUtils.getDefaultJBossJndiContext();
		QueueConnectionFactory qcf = JndiUtils.lookup(context, "ConnectionFactory", QueueConnectionFactory.class);
		QueueConnection connection = (QueueConnection) qcf.createConnection();
		QueueSession queueSession = connection.createQueueSession(false, Session.AUTO_ACKNOWLEDGE);
		Queue queue= JndiUtils.lookup(context, "queue/ExpiryQueue",Queue.class);
		QueueSender queueSender = queueSession.createSender(queue);
		TextMessage msg = queueSession.createTextMessage();
		msg.setText("Helloooo");
		//11182
		queueSender.send(msg );
		
		queueSender.close();
		connection.close();
	}
	
}

class TestMessageListener implements MessageListener
{

	@Override
	public void onMessage(Message msg)
	{
		try
		{
			System.out.println("Message-->"+((TextMessage)msg).getText());
		} catch (JMSException e)
		{
			e.printStackTrace();
		}
	}
	
}
