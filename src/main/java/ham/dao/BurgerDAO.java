package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.BurgerDTO;

@Repository
public interface BurgerDAO extends JpaRepository<BurgerDTO,Integer> {

	List<BurgerDTO> findAllByTypeOrderByBurgerSeqDesc(@Param("type") int type);

	List<BurgerDTO> findFirst5ByTypeOrderByBurgerSeqDesc(@Param("type") int type);

}
