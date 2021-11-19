package com.capgemini.ebugtracker.mailsender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
public class Mailsender {

    private String sender_id="viajyalaxmi.joshi8@gmail.com";

    public String getReceiver_id() {
        return receiver_id;
    }

    public void setReceiver_id(String receiver_id) {
        this.receiver_id = receiver_id;
    }

    private String receiver_id;
    private String username;
    private String password;
    @Autowired
    public JavaMailSender javaMailSender;

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



    public void sendmail(){
        SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(sender_id);
        msg.setTo(receiver_id);

        msg.setSubject("E-Bug Tracker System");
        msg.setText("Hi");
        msg.setText("Username"+username+"\n"+"Password"+password);
        javaMailSender.send(msg);
    }
    
    public void sendmail(Long bugid) {
    	SimpleMailMessage msg = new SimpleMailMessage();
        msg.setFrom(sender_id);
        msg.setTo(receiver_id);

        msg.setSubject("E-Bug Tracker System");
        msg.setText("Hi");
        msg.setText("Ticket Id:"+bugid+"This ticked is resolved succesfuly");
       
        javaMailSender.send(msg);
    }
}
