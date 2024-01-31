package ham.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ham.bean.UserDTO;
import ham.service.UserService;

@RestController
public class UserController {
	
	@Autowired
	private UserService userService;
		
	@PostMapping
	public boolean checkEmail(@RequestBody UserDTO userDTO) {
		String email = userDTO.getEmail();
		
		return userService.checkEmail(email);
	}
}
