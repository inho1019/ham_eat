package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.RatingDTO;

@Repository
public interface RatingDAO extends JpaRepository<RatingDTO,Integer> {

	List<RatingDTO> findAllByTypeOrderByRatingSeqDesc(@Param("type")int type);

	@Query("SELECT r.*, u.name as user_name FROM rating r JOIN user u ON r.user_seq = u.user_seq WHERE r.burger_seq = :burger_seq")
	List<RatingDTO> findAllByBurgerSeqOrderByRatingSeqDesc(long burgerSeq);
	
}
