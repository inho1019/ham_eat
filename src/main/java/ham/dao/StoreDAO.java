package ham.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ham.bean.StoreDTO;

@Repository
public interface StoreDAO extends JpaRepository<StoreDTO,Long> {

	List<StoreDTO> findAllByTypeOrderByStoreSeqDesc(@Param("type") int type);

	Optional<StoreDTO> findByPlaceId(@Param("placeId") String placeId);

}
