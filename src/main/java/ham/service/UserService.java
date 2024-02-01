package ham.service;

import java.util.Map;

import ham.bean.UserDTO;

public interface UserService {

	public boolean checkEmail(String email);

	public boolean register(UserDTO userDTO);

	public boolean checkName(String name);

	public Map<String, Object> login(UserDTO userDTO);

	public UserDTO getSeq(int userSeq);

}
