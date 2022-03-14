package com.holautism.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class EmailController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/contact")
	public String showContactForm() {
		return "contact";
	}
		
	@PostMapping("/contact")
	public String submitContact(HttpServletRequest request) {
		
		String name = request.getParameter("name");
		String emailAddress = request.getParameter("emailAddress");
		String subject = request.getParameter("subject");
		String content = request.getParameter("content");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("test@gmail.com");
		message.setTo("x20146825@student.ncirl.ie");
		
		String mailSubject = name + " has emailed you";
		String mailContent = "Sender name: " + name + "\n";
		mailContent += "Sender e-mail: " + emailAddress + "\n";
		mailContent += "Subject: " + subject + "\n";
		mailContent += "Content: " + content + "\n";
		
		message.setSubject(mailSubject);
		message.setText(mailContent);
		
		mailSender.send(message);
		
		return "message";
	}
}
