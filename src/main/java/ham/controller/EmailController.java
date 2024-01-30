package ham.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ham.service.EmailService;
import jakarta.mail.MessagingException;

@RestController
public class EmailController {

	@Autowired
    private EmailService emailService;

    @PostMapping("user/email")
    public String mailConfirm(@RequestParam String email) throws UnsupportedEncodingException, MessagingException {

        String authCode = emailService.sendEmail(email);
        return authCode;
    }
}
