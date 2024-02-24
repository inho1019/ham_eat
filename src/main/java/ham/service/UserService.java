package ham.service;

import java.util.Map;

import ham.bean.UserDTO;
import ham.controller.UserController.UpdateDTO;

public interface UserService {

	public boolean checkEmail(String email);

	public boolean register(UserDTO userDTO);

	public boolean checkName(String name);

	public Map<String, Object> login(UserDTO userDTO);

	public boolean update(int field, String value, long userSeq);

	public boolean checkPwd(UserDTO userDTO);

	public boolean delete(long userSeq);

	public void putSecretKey(long userSeq, String secret);

	public String getSecretKey(long userSeq);

	public UserDTO getUserDTO(long parseLong);
}
