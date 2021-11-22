package com.capgemini.ebugtracker.mailsender;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

@Service
public class Mailsender {

    private String sender_id="vijayalaxmi.joshi8@gmail.com";
    private String receiver_id;
    private String username;
    private String password;
    @Autowired
    public JavaMailSender javaMailSender;

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    

    public String getSender_id() {
        return sender_id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setSender_id(String sender_id) {
        this.sender_id = sender_id;
    }



    public void sendmail() throws MessagingException{
        MimeMessage mimemsg = javaMailSender.createMimeMessage();
        MimeMessageHelper msg=new MimeMessageHelper(mimemsg,true);
        msg.setFrom(sender_id);
        msg.setTo(receiver_id);

        msg.setSubject("E-Bug Tracker System");
        msg.setText("Hi");
        msg.setText("Username"+username+"\n"+"Password"+password);
        javaMailSender.send(mimemsg);
    }
    
    public void sendmail(Long bugid) {
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(sender_id);
        msg.setTo(receiver_id);

        msg.setSubject("E-Bug Tracker System");
        msg.setText("Hi");
        msg.setText("Ticket Id:"+bugid+"This ticket is resolved succesfuly");
       
        javaMailSender.send(msg);
    }
}
