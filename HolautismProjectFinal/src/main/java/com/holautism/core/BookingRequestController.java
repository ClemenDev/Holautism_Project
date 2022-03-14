package com.holautism.core;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookingRequestController {
	
	@Autowired
	private JavaMailSender mailSender;
	
	@GetMapping("/booking_usu")
	public String showBookingRequestFormUsu() {
		return "booking_usu";
	}
	
	@PostMapping("/booking_usu")
	public String submitContact(HttpServletRequest request) {
		
		String clientName = request.getParameter("clientName");
		String emailAddress = request.getParameter("emailAddress");
		String professionalName = request.getParameter("professionalName");
		
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom("test@gmail.com");
		message.setTo("x20146825@student.ncirl.ie");
		
		String mailSubject = clientName + " has requested a professional service";
		String mailContent = "Sender name: " + clientName + "\n";
		mailContent += "Sender e-mail: " + emailAddress + "\n";
		mailContent += "Professional requested name: " + professionalName + "\n";
		mailContent += "'IMPORTANT MESSAGE BELOW'" + "\n";
		mailContent += "Please " + professionalName + " email back to " + clientName +  " with either 'request confirmed' or 'request cancelled'" + "\n";
		
		message.setSubject(mailSubject);
		message.setText(mailContent);
		
		mailSender.send(message);
		
		return "pro_message";
	}
	
	@GetMapping("/booking_carlos")
	public String showBookingRequestFormCarlos() {
		return "booking_carlos";
	}
	
	@GetMapping("/booking_maria")
	public String showBookingRequestFormMaria() {
		return "booking_maria";
	}
	
	@GetMapping("/booking_monica")
	public String showBookingRequestFormMonica() {
		return "booking_monica";
	}

}
