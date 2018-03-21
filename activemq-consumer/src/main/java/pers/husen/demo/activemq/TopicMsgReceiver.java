package pers.husen.demo.activemq;

import javax.annotation.Resource;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.annotation.Bean;
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
@Component("topicMsgReceiver")
public class TopicMsgReceiver extends MessageListenerAdapter {
	@Resource(name = "jmsTopicTemplate")
	private JmsTemplate jmsTopicTemplate;

	private static final String EMAIL_TOPIC = "topic:pers.husen.demo.email";

	/**
	 * 定义Topic名称,在配置文件中注入监听容器
	 * 
	 * @return
	 */
	@Bean(name = "topicDestination")
	private ActiveMQTopic initTopicDestination() {
		return new ActiveMQTopic(EMAIL_TOPIC);
	}

	@Override
	public void onMessage(Message message, Session session) throws JMSException {
		try {
			SimpleEmailParams emailParams = (SimpleEmailParams) getMessageConverter().fromMessage(message);
			System.out.println("订阅者收到：" + emailParams.getMailTo());
			System.out.println("当前会话详情：" + session);

			message.acknowledge();
		} catch (MessageConversionException | JMSException e) {
			e.printStackTrace();

			// 发送异常，重新放回队列
			jmsTopicTemplate.send(EMAIL_TOPIC, new MessageCreator() {
				@Override
				public Message createMessage(Session session) throws JMSException {
					return jmsTopicTemplate.getMessageConverter().toMessage(message, session);
				}
			});
		}
	}
}