package ham.controller;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.UserDTO;
import ham.service.EmailService;
import ham.service.UserService;
import jakarta.mail.MessagingException;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@Autowired
    private EmailService emailService;
	
	@PostMapping("user/email")
    public String mailConfirm(@RequestBody UserDTO userDTO) throws UnsupportedEncodingException, MessagingException {

    	String email = userDTO.getEmail();
    	
        String authCode = emailService.sendEmail(email);
        return authCode;
    }
	
	@PostMapping("user/emailCheck")
	public boolean checkEmail(@RequestBody UserDTO userDTO) {
		String email = userDTO.getEmail();
		
		return userService.checkEmail(email);
	}
	@PostMapping("user/nameCheck")
	public boolean checkName(@RequestBody UserDTO userDTO) {
		String name = userDTO.getName();
		
		return userService.checkName(name);
	}
	
	@PostMapping("user/register")
	public boolean register(@RequestBody UserDTO userDTO) {
		return userService.register(userDTO);
	}
}
