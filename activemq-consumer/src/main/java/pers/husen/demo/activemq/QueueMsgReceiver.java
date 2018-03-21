package pers.husen.demo.activemq;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.jms.listener.adapter.MessageListenerAdapter;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.stereotype.Component;

import pers.husen.demo.activemq.vo.SimpleEmailParams;

/**
 * @Desc 队列接收，根据队列名称调用相关服务
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月20日 下午4:16:02
 * 
 * @Version 1.0.1
 */
@Component("queueMsgReceiver")
public class QueueMsgReceiver extends MessageListenerAdapter {
	/** 通过@Qualifier修饰符来注入对应的bean */
	@Resource(name = "jmsQueueTemplate")
	private JmsTemplate jmsQueueTemplate;

	private static final String EMAIL_QUEUE = "queue:pers.husen.demo.email";

	@Override
	@JmsListener(containerFactory = "jmsListenerContainerFactory", destination = EMAIL_QUEUE, concurrency = "5-10")
	public synchronized void onMessage(Message message, Session session) throws JMSException {
		try {
			// TextMessage msg = (TextMessage) message;
			// final String ms = msg.getText();
			SimpleEmailParams emailParams = (SimpleEmailParams) getMessageConverter().fromMessage(message);
			System.out.println("点对点收到：" + emailParams.getMailTo());
			System.out.println("当前会话详情：" + session);

			message.acknowledge();
		} catch (MessageConversionException | JMSException e) {
			e.printStackTrace();

			// 发送异常，重新放回队列
			jmsQueueTemplate.send(EMAIL_QUEUE, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return jmsQueueTemplate.getMessageConverter().toMessage(message, session);
				}
			});
		}
	}
}