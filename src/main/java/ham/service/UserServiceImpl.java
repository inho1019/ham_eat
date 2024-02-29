package ham.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import ham.bean.UserDTO;
import ham.bean.VariDTO;
import ham.dao.UserDAO;
import ham.dao.VariDAO;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDAO userDAO;
	
	@Autowired
	private VariDAO variDAO;
	
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

	@Override
	public Map<String, Object> login(UserDTO userDTO) {
		Map<String,Object> map = new HashMap<>();
		Optional<UserDTO> loginDTO = userDAO.findByEmail(userDTO.getEmail());
		
		if (loginDTO.isPresent()) {
			UserDTO dto = loginDTO.orElse(null);
			if( passwordEncoder.matches(userDTO.getPwd(), dto.getPwd()) ) {
				map.put("bool",true);
				map.put("userDTO",dto);
			} else {				
				map.put("bool",false);
			}
		} else {
			map.put("bool",false);
		}
		
		return map;
	}

	@Override
	public boolean update(int field, String value, long userSeq) {
		
		UserDTO userDTO = userDAO.findById(userSeq).orElse(null);
		
		try {
			if(field == 0) {
				userDTO.setName(value);
			} else if(field == 1) {
				userDTO.setPwd(passwordEncoder.encode(value));
			} else if(field == 2) {
				userDTO.setOwn(Integer.parseInt(value));
			}
			
			userDAO.save(userDTO);
			
			return true;
		} catch(Exception e) {
			System.out.println("변경 중 오류 발생 :: " + e);
			
			return false;
		}
	}

	@Override
	public boolean checkPwd(UserDTO userDTO) {
		if( passwordEncoder.matches(userDTO.getPwd(), 
				userDAO.findById(userDTO.getUserSeq()).orElse(null).getPwd()) ) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean delete(long userSeq) {
		try {
			userDAO.deleteById(userSeq);
			
			return true;
		} catch(Exception e) {
			System.out.println("회원 탈퇴 중 오류 발생 :: " + e);
			
			return false;
		}
	}


	@Override
	public void putSecretKey(long userSeq, String secret) {
		UserDTO userDTO = userDAO.findById(userSeq).orElse(null);
		userDTO.setSecretKey(secret);
		userDAO.save(userDTO);
	}

	@Override
	public String getSecretKey(long userSeq) {
		return userDAO.findSecretKeyByUserSeq(userSeq);
	}

	@Override
	public UserDTO getUserDTO(long userSeq) {
		return userDAO.findById(userSeq).orElse(null);
	}

	@Override
	public List<UserDTO> userList() {
		return userDAO.findAll();
	}

	@Override
	public void variSet(VariDTO variDTO) {
		
		Optional<VariDTO> opDTO = variDAO.findByName(variDTO.getName());
		
		if(opDTO.isPresent()) {
			VariDTO upDTO = opDTO.orElse(null);
			upDTO.setValu(variDTO.getValu());
			variDAO.save(upDTO);
		} else {
			variDAO.save(variDTO);
		}
	}

	@Override
	public String variGet(String name) {
		return variDAO.findByName(name).orElse(null).getValu();
	}
}
