package utils;

import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class MailUtils {

	public static void sendMail(String email, String emailMsg) {
		// 1.创建一个程序与邮件服务器会话对象 Session

		Properties props = new Properties();
		//设置发送的协议
		props.setProperty("mail.transport.protocol", "SMTP");

	//	设置发送邮件的服务器
		props.setProperty("mail.host", "smtp.qq.com");
		props.setProperty("mail.smtp.auth", "true");// 指定验证为true

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				//设置发送人的帐号和密码[邮箱的授权码]
				return new PasswordAuthentication("670049410@qq.com", "xxxxxxxxxxxxx");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		try {
			//设置发送者
			message.setFrom(new InternetAddress("670049410@qq.com"));

			//设置发送方式与接收者
			message.setRecipient(RecipientType.TO, new InternetAddress(email));

			//设置邮件主题
			message.setSubject("用户激活");
			// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

			String url="http://localhost:8080/aigoubuy/userServlet?method=active&code="+emailMsg;
			String content="<h1>来自购物天堂的激活邮件!激活请点击以下链接!</h1><h3><a href='"+url+"'>"+url+"</a></h3>";
			//设置邮件内容
			message.setContent(content, "text/html;charset=utf-8");

			// 3.创建 Transport用于将邮件发送
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 本地邮件发送
	 * @param email
	 * @param emailMsg
	 */
	public static void sendMail2(String email, String emailMsg) {
		// 1.创建一个程序与邮件服务器会话对象 Session
		Properties props = new Properties();
		//	设置发送邮件的服务器
		props.setProperty("mail.host", "localhost");

		// 创建验证器
		Authenticator auth = new Authenticator() {
			public PasswordAuthentication getPasswordAuthentication() {
				//设置发送人的帐号和密码[邮箱的授权码]
				return new PasswordAuthentication("service@store.com", "111");
			}
		};

		Session session = Session.getInstance(props, auth);

		// 2.创建一个Message，它相当于是邮件内容
		Message message = new MimeMessage(session);

		try {
			//设置发送者
			message.setFrom(new InternetAddress("service@store.com"));

			//设置发送方式与接收者
			message.setRecipient(RecipientType.TO, new InternetAddress(email));

			//设置邮件主题
			message.setSubject("用户激活");
			// message.setText("这是一封激活邮件，请<a href='#'>点击</a>");

			String url="http://localhost:8080/igobuy/userServlet?method=active&code="+emailMsg;
			String content="<h1>来自购物天堂的激活邮件!激活请点击以下链接!</h1><h3><a href='"+url+"'>"+url+"</a></h3>";
			//设置邮件内容
			message.setContent(content, "text/html;charset=utf-8");

			// 3.创建 Transport用于将邮件发送
			Transport.send(message);
		} catch (MessagingException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) throws AddressException, MessagingException {
		//MailUtils.sendMail("1913136797@qq.com", "123456789");
		MailUtils.sendMail2("1913136797@qq.com", "123456789");
	}
}
