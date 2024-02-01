package ham.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.RatingDTO;

@Repository
public interface RatingDAO extends JpaRepository<RatingDTO,Integer> {

	@Query("SELECT new ham.bean.RatingDTO(r.ratingSeq, r.burgerSeq, r.userSeq, r.type, r.rate, r.content, r.logTime, u.name, u.birth, u.gender) "
			+ "FROM RatingDTO r JOIN UserDTO u ON r.userSeq = u.userSeq WHERE r.type = :type ORDER BY r.ratingSeq DESC")
	List<RatingDTO> findAllByTypeOrderByRatingSeqDesc(@Param("type")int type);

	@Query("SELECT new ham.bean.RatingDTO(r.ratingSeq, r.burgerSeq, r.userSeq, r.type, r.rate, r.content, r.logTime, u.name, u.birth, u.gender) "
			+ "FROM RatingDTO r JOIN UserDTO u ON r.userSeq = u.userSeq WHERE r.burgerSeq = :burgerSeq ORDER BY r.ratingSeq DESC")
	List<RatingDTO> findAllByBurgerSeqOrderByRatingSeqDesc(@Param("burgerSeq") long burgerSeq);
	
}
