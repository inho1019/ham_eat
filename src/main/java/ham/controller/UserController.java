package ham.controller;

import java.io.UnsupportedEncodingException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.UserDTO;
import ham.service.EmailService;
import ham.service.UserService;
import jakarta.mail.MessagingException;
import lombok.Getter;
import lombok.Setter;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@Autowired
    private EmailService emailService;
	
	@Getter
	@Setter
	public static class UpdateDTO {
		private int field;
		private String value;
		private long userSeq;
    }
	
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
	
	@PostMapping("user/login")
	public Map<String,Object> login(@RequestBody UserDTO userDTO) {
		return userService.login(userDTO);
	}
	
	@PutMapping("user/update")
	public boolean update(@RequestBody UpdateDTO updateDTO) {
		int field = updateDTO.getField();
		String value = updateDTO.getValue();
		long userSeq = updateDTO.getUserSeq();
 		return userService.update(field,value,userSeq);
	}
	
	@PostMapping("user/checkPwd")
	public boolean checkPwd(@RequestBody UserDTO userDTO) {
		return userService.checkPwd(userDTO);
	}
	
	@DeleteMapping("user/delete")
	public boolean delete(@RequestBody UserDTO userDTO) {
		return userService.delete(userDTO);
	}
}
