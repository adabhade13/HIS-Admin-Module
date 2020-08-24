package com.his.utils;

import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

import com.his.entity.AccountEntity;


@Component
public class EmailUtils {
	

    @Autowired
    private JavaMailSender emailSender;
	
	public  boolean sendEmail(String to,String subject,AccountEntity acoount){
		
	    try {
		String body = EmailTemplate.getTemplate(acoount);
		
		MimeMessage message = emailSender.createMimeMessage();
	     
	    MimeMessageHelper helper = new MimeMessageHelper(message);
	    
	    helper.setFrom("adabhade13@gmail.com");
	    helper.setTo(to);
	    helper.setSubject(subject);
	    
	
			helper.setText(body, true);
			emailSender.send(message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
		return true;
	}

}
