package pers.husen.sendemail;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import com.sun.mail.util.MailSSLSocketFactory;

public class SendEmail {
	public static void main(String[] args) {
		try {
			// 建立属性对象
			Properties properties = new Properties();
			// 开启SSL
			MailSSLSocketFactory sf = new MailSSLSocketFactory();
			sf.setTrustAllHosts(true);
			// 开启认证
			properties.put("mail.smtp.auth", "true");
			// 开启SSL
			properties.put("mail.smtp.ssl.enable", "true");
			properties.put("mail.smtp.ssl.socketFactory", sf);
			// 设置邮件服务器主机名
			properties.setProperty("mail.host", "smtp.qq.com");
			// 设置端口
			properties.setProperty("mail.smtp.port", "465");

			// 根据认证获取默认session对象
			Session session = Session.getDefaultInstance(properties, new Authenticator() {
				@Override
				public PasswordAuthentication getPasswordAuthentication() {
					return new PasswordAuthentication("husen@hemingsheng.cn", "jzzhdalrrqtmbddc");
				}
			});
			// 创建默认的 MimeMessage 对象
			MimeMessage message = new MimeMessage(session);
			// Set From: 头部头字段
			message.setFrom(new InternetAddress("husen@hemingsheng.cn", "何明胜", "UTF-8"));
			// 收件人电子邮箱 可用数组设置多个
			message.addRecipient(Message.RecipientType.TO, new InternetAddress("1123767053@qq.com"));
			// 要求阅读回执(收件人阅读邮件时会提示回复发件人,表明邮件已收到,并已阅读)  
	        //message.setHeader("Disposition-Notification-To", "940706904@qq.com");  
	        
			// 设置标题
			message.setSubject("来自测试的邮件标题!");
			
			// 设置邮件内容 普通文本
			// message.setText("测试邮件内容");
			// 设置内容 HTML
			message.setContent("邮件内容123", "text/html;charset=UTF-8");
			
			/** 带附件 * */
			/*// 文本内容
			MimeBodyPart contentBodyPart = new MimeBodyPart();
			contentBodyPart.setContent("<p>测试邮件的段落</p>", "text/html; charset=utf-8");
			// 附件
			MimeBodyPart fileMultiPart = new MimeBodyPart();
			fileMultiPart.setDataHandler(new DataHandler(new FileDataSource(new File("D:\\Desktop\\简历.docx"))));
			// 图片
			MimeBodyPart picMultiPart = new MimeBodyPart();
			picMultiPart.setDataHandler(new DataHandler(new FileDataSource("D:\\Desktop\\logo.png")));
			picMultiPart.setContentID("logo.png");
			// 组合
			MimeMultipart bodyMultipart = new MimeMultipart("mixed");
			bodyMultipart.addBodyPart(contentBodyPart);
			bodyMultipart.addBodyPart(fileMultiPart);
			bodyMultipart.addBodyPart(picMultiPart);
			message.setContent(bodyMultipart);*/

			// 发送信息的工具
			Transport transport = session.getTransport();
			// 发件人邮箱号和密码
			// transport.connect("940706904@qq.com", "jzzhdalrrqtmbddc");
			transport.connect();
			transport.sendMessage(message, new Address[] { new InternetAddress("1123767053@qq.com") });// 对方的地址
			// 关闭连接
			transport.close();
			System.out.println("Sent message successfully....from console");
		} catch (MessagingException | UnsupportedEncodingException | GeneralSecurityException mex) {
			mex.printStackTrace();
		}
	}
}