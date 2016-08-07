package cn.tf.mail;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

//只有文本的邮件
public class Demo1 {
	
	public static void main(String[] args) throws AddressException, MessagingException, FileNotFoundException, IOException {
		Properties props=new Properties();
		Session session=Session.getInstance(props);
		MimeMessage message=new MimeMessage(session);
		
		message.setFrom(new InternetAddress("xingtian@tianfang1314.cn"));
		message.setRecipients(Message.RecipientType.TO, "zhupei@tianfang1314.cn");
		message.setSubject("邮件测试");
		message.setContent("<h1>今天加班哦，各单位请注意</h1>","text/html;charset=UTF-8");
		
		message.saveChanges();
		//把邮件保存到磁盘
		message.writeTo(new FileOutputStream("d:/1.eml"));
		
		
	}

}
