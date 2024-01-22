package ham.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ham.bean.RatingDTO;

@Repository
public interface RatingDAO extends JpaRepository<RatingDTO,Integer> {
	
}
