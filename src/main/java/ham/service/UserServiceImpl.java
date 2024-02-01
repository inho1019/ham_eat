package ham.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ham.bean.UserDTO;
import ham.dao.UserDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Override
	public boolean checkEmail(String email) {
		return userDAO.findByEmail(email).isPresent();
	}

	@Override
	public boolean register(UserDTO userDTO) {
		try {
			userDTO.setPwd(passwordEncoder.encode(userDTO.getPwd()));
			
			userDAO.save(userDTO);
			
			return true;
		} catch(Exception e) {
			System.out.println("회원가입 중 오류 발생 :: " + e);
			
			return false;
		}
 	}

	@Override
	public boolean checkName(String name) {
		return userDAO.findByName(name).isPresent();
	}

}
