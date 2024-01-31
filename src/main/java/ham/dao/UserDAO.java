package ham.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO,Integer> {

	public Optional<UserDTO> findByEmail(@Param("email") String email);

	public Optional<UserDTO> findByName(@Param("name") String name);
}
