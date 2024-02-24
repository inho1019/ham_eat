package ham.dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.UserDTO;

@Repository
public interface UserDAO extends JpaRepository<UserDTO,Long> {

	public Optional<UserDTO> findByEmail(@Param("email") String email);

	public Optional<UserDTO> findByName(@Param("name") String name);

	@Query("SELECT secretKey FROM UserDTO u WHERE u.userSeq = :userSeq")
	public String findSecretKeyByUserSeq(@Param("userSeq") long userSeq);
}
