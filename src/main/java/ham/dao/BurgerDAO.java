package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.BurgerDTO;

@Repository
public interface BurgerDAO extends JpaRepository<BurgerDTO,Long> {

	@Query("SELECT b, u FROM BurgerDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq WHERE b.type = :type ORDER BY b.burgerSeq DESC")
	List<Object> selectTypeJoin(@Param("type") int type);

	List<BurgerDTO> findFirst3ByTypeOrderByBurgerSeqDesc(@Param("type") int type);

	@Query("SELECT b, u FROM BurgerDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq WHERE b.burgerSeq = :burgerSeq")
	Object oneSeqJoin(@Param("burgerSeq") long burgerSeq);

	@Query("SELECT b, u FROM BurgerDTO b LEFT JOIN UserDTO u ON b.userSeq = u.userSeq ORDER BY b.burgerSeq DESC")
	List<Object> selectAllJoin();

	@Query(value = "SELECT * FROM burger WHERE type = 0 AND status = 0 ORDER BY RAND() LIMIT 1", nativeQuery = true)
	BurgerDTO getRandomBurger();
}
