package com.org.sendMail;

public class TestSendMail {
    public static void main(String args[]) {
        // 设置邮件服务器信息
        MailSenderInfo mailInfo = new MailSenderInfo();
        mailInfo.setMailServerHost("smtp.163.com");
        mailInfo.setMailServerPort("25");
        mailInfo.setValidate(true);
        // 邮箱用户名
        mailInfo.setUserName("15268942765@163.com");
        // 邮箱密码
        mailInfo.setPassword("zhong0213");
       // 发件人邮箱
        mailInfo.setFromAddress("15268942765@163.com");
       // 收件人邮箱
        mailInfo.setToAddress("1466675175@qq.com");
       // 邮件标题
        mailInfo.setSubject("测试邮件");
        // 邮件内容
        StringBuffer buffer = new StringBuffer();
        buffer.append("测试已成功！");
        mailInfo.setContent(buffer.toString());
        // 发送邮件
        SimpleMailSender sms = new SimpleMailSender();
        // 发送文体格式
        sms.sendHtmlMail(mailInfo);
        // 发送html格式
        SimpleMailSender.sendHtmlMail(mailInfo);
        System.out.println("邮件发送完毕");
    }
}


