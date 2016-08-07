package cn.tf.mail;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//只有文本的邮件
public class Demo2 {
	
	public static void main(String[] args) throws AddressException, MessagingException, FileNotFoundException, IOException {
		Properties props=new Properties();
		
		props.setProperty("mail.transport.protocol", "smtp");//规范规定的参数
		props.setProperty("mail.host", "smtp.mxhichina.com");//这里使用万网的邮箱主机
		props.setProperty("mail.smtp.auth", "true");//请求认证，不认证有可能发不出去邮件。
		
		
		Session session=Session.getInstance(props);
		MimeMessage message=new MimeMessage(session);
		
		message.setFrom(new InternetAddress("xingtian@tianfang1314.cn"));
		message.setRecipients(Message.RecipientType.TO, "zhupei@tianfang1314.cn");
		message.setSubject("邮件测试");
		message.setContent("<h1>今天加班哦，各单位请注意</h1>","text/html;charset=UTF-8");
		
		message.saveChanges();
		
		Transport  tp=session.getTransport();
		
		//邮箱账号密码
		tp.connect("账号","密码");
		tp.sendMessage(message, message.getAllRecipients());
		tp.close();
		
		
	}

}
