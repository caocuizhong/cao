package com.org.controller;
import java.io.File;
import java.nio.file.Paths;
import java.util.Properties;
import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.Authenticator;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;
public class SendMailFile {
    public static void main(String[] args) {
        String attachment = "E:" + File.separator + "mail.rar";
        String to = "1466675175@qq.com";
        String from = "15268942765@163.com";
        final String userName = "15268942765@163.com";
        final String password = "zhong0213";
        String host = "smtp.163.com";
        Properties props = new Properties();
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.starttls.enable", "true");
        props.put("mail.smtp.host", host);
        props.put("mail.smtp.port", "25");
       // 获取会话对象
        Session session = Session.getInstance(props, new Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(userName, password);
            }
        });
        try {
            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress(from));
            message.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to));
            message.setSubject("Nice to meet you, JavaMail!");
            BodyPart textBodyPart = new MimeBodyPart();
            textBodyPart.setText("I have a dream!!!");
            BodyPart messageBodyPart = new MimeBodyPart();
            DataSource source = new FileDataSource(attachment);
            messageBodyPart.setDataHandler(new DataHandler(source));
            messageBodyPart.setFileName(Paths.get(attachment).getFileName().toString());

            Multipart mp = new MimeMultipart();
            mp.addBodyPart(textBodyPart);
            mp.addBodyPart(messageBodyPart);
            message.setContent(mp);
            System.out.println("邮件发送中");
            Transport.send(message);
            System.out.println("发送成功！");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }
}
