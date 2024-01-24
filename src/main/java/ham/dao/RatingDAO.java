package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.RatingDTO;

@Repository
public interface RatingDAO extends JpaRepository<RatingDTO,Integer> {

	List<RatingDTO> findAllByTypeOrderByRatingSeqDesc(@Param("type")int type);

	List<RatingDTO> findAllByBurgerSeqOrderByRatingSeqDesc(@Param("burgerSeq")int burgerSeq);
	
}
