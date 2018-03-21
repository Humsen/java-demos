package pers.husen.demo.activemq;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

/**
 * @Desc 订阅消息
 *
 * @Author 何明胜
 *
 * @Created at 2018年3月20日 下午4:13:28
 * 
 * @Version 1.0.1
 */
@Service("topicMsgPublisher")
public class TopicMsgPublisher {
	@Resource(name = "jmsTopicTemplate")
	private JmsTemplate jmsTopicTemplate;

	/**
	 * 发布一条对象消息
	 * 
	 * @param destination
	 *            目的地
	 * @param message
	 */
	public void publishMessage(String destination, final Object message) {
		jmsTopicTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return jmsTopicTemplate.getMessageConverter().toMessage(message, session);
			}
		});

		System.out.println("destination:" + destination + ", message:" + message);
	}

	/**
	 * 发布一条文本消息
	 * 
	 * @param destination
	 * @param message
	 */
	public void publishMessage(String destination, final String message) {
		jmsTopicTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(message);
			}
		});

		System.out.println("destination:" + destination + ", message:" + message);
	}
}