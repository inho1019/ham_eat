package ham.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.service.EmailService;
import jakarta.mail.MessagingException;

@RestController
public class EmailController {

	@Autowired
    private EmailService emailService;
	
	private static class EmailDTO {
	    private String email;

	    public String getEmail() {
	        return email;
	    }
	}

    @PostMapping("user/email")
    public String mailConfirm(@RequestBody EmailDTO emailDTO) throws UnsupportedEncodingException, MessagingException {

    	String email = emailDTO.getEmail();
    	
        String authCode = emailService.sendEmail(email);
        return authCode;
    }
}
