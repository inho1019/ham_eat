package ham.service;

import ham.bean.UserDTO;

public interface UserService {

	public boolean checkEmail(String email);

	public boolean register(UserDTO userDTO);

	public boolean checkName(String name);

}
